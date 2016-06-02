/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datazuul.iiif.presentation.backend.repository.impl;

import com.datazuul.iiif.presentation.api.model.Manifest;
import com.datazuul.iiif.presentation.backend.repository.PresentationRepository;
import com.datazuul.iiif.presentation.backend.repository.resolver.PresentationResolver;
import com.datazuul.iiif.presentation.model.NotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

/**
 * Default implementation trying to get manifest.json from an resolved URI as String and returning Manifest instance.
 *
 * @author Ralf Eichinger (ralf.eichinger at gmail.com)
 */
@Repository
public class PresentationRepositoryImpl implements PresentationRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(PresentationRepositoryImpl.class);

  @Autowired
  private ApplicationContext applicationContext;

  private final Cache<String, Manifest> httpCache;

  private final Executor httpExecutor;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired(required = true)
  List<PresentationResolver> resolvers;

  public PresentationRepositoryImpl() {
    this.httpExecutor = Executor.newInstance();
    httpCache = CacheBuilder.newBuilder().maximumSize(32).build();
  }

  @Override
  public Manifest getManifest(String identifier) throws NotFoundException {
    LOGGER.debug("Try to get manifest for: " + identifier);

    LOGGER.debug("START getManifest() for " + identifier);
    PresentationResolver resolver = getManifestResolver(identifier);
    URI manifestUri = resolver.getURI(identifier);

    return getManifest(manifestUri);
  }

  @Override
  public Manifest getManifest(URI manifestUri) throws NotFoundException {
    String location = manifestUri.toString();
    LOGGER.info("Trying to get manifest from " + location);
    Manifest manifest = null;
    String json;
    try {
      if (manifestUri.getScheme().equals("file")) {
        json = getManifestJson(manifestUri);
        manifest = objectMapper.readValue(json, Manifest.class);
      } else if (manifestUri.getScheme().equals("classpath")) {
        json = getManifestJson(manifestUri);
        manifest = objectMapper.readValue(json, Manifest.class);
      } else if (manifestUri.getScheme().startsWith("http")) {
        String cacheKey = getCacheKey(location);
        manifest = httpCache.getIfPresent(cacheKey);
        if (manifest == null) {
          LOGGER.debug("HTTP Cache miss!");
          json = getManifestJson(manifestUri);
          manifest = objectMapper.readValue(json, Manifest.class);
          httpCache.put(cacheKey, manifest);
        } else {
          LOGGER.debug("HTTP Cache hit!");
        }
      }
    } catch (IOException e) {
      throw new NotFoundException(e);
    }
    LOGGER.debug("DONE getManifest() for " + location);
    if (manifest == null) {
      throw new NotFoundException("No manifest for identifier: " + location);
    }
    return manifest;
  }

  @Override
  public String getManifestJson(URI manifestUri) throws NotFoundException {
    String location = manifestUri.toString();
    String json = null;
    try {
      if (manifestUri.getScheme().equals("file")) {
        json = IOUtils.toString(manifestUri);
      } else if (manifestUri.getScheme().equals("classpath")) {
        Resource resource = applicationContext.getResource(manifestUri.toString());
        InputStream is = resource.getInputStream();
        json = IOUtils.toString(is);
      } else if (manifestUri.getScheme().startsWith("http")) {
        json = httpExecutor.execute(Request.Get(manifestUri)).returnContent().asString();
      }
    } catch (IOException e) {
      throw new NotFoundException(e);
    }
    LOGGER.debug("DONE getManifestJson() for " + location);
    return json;
  }

  @Override
  public JSONObject getManifestAsJsonObject(URI manifestUri) throws NotFoundException, ParseException {
    String json = getManifestJson(manifestUri);
    JSONParser parser = new JSONParser();
    Object obj = parser.parse(json);
    JSONObject jsonObject = (JSONObject) obj;
    return jsonObject;
  }

  private PresentationResolver getManifestResolver(String identifier) throws NotFoundException {
    for (PresentationResolver resolver : resolvers) {
      if (resolver.isResolvable(identifier)) {
        String msg = identifier + " resolved with this resolver: " + resolver.getClass().
                getSimpleName();
        LOGGER.debug(msg);
        return resolver;
      }
    }
    String msg = "No resolver found for identifier '" + identifier + "'";
    throw new NotFoundException(msg);
  }

  private String getCacheKey(String identifier) {
    return String.format("iiif.manifest.%s", identifier);
  }

  @Override
  public JSONObject getManifestAsJsonObject(String manifestUri) throws URISyntaxException, NotFoundException, ParseException {
    return getManifestAsJsonObject(new URI(manifestUri));
  }
}
