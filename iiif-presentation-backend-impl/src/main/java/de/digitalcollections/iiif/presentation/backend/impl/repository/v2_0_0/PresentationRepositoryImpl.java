package de.digitalcollections.iiif.presentation.backend.impl.repository.v2_0_0;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import de.digitalcollections.core.business.api.ResourceService;
import de.digitalcollections.core.model.api.resource.Resource;
import de.digitalcollections.core.model.api.resource.enums.ResourcePersistenceType;
import de.digitalcollections.core.model.api.resource.exceptions.ResourceIOException;
import de.digitalcollections.iiif.presentation.backend.api.exceptions.NotFoundException;
import de.digitalcollections.iiif.presentation.backend.api.repository.v2_0_0.PresentationRepository;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Manifest;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Default implementation trying to get manifest.json from an resolved URI as String and returning Manifest instance.
 */
@Repository(value = "PresentationRepositoryImpl-v2.0.0")
public class PresentationRepositoryImpl implements PresentationRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(PresentationRepositoryImpl.class);

  private final Cache<String, Manifest> httpCache;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private ResourceService resourceService;

  public PresentationRepositoryImpl() {
    httpCache = CacheBuilder.newBuilder().maximumSize(32).build();
  }

  @Override
  public Manifest getManifest(String identifier) throws NotFoundException {
    Resource resource;
    try {
      String key = identifier + "_manifest.json";
      resource = resourceService.get(key, ResourcePersistenceType.REFERENCED, "json");
    } catch (ResourceIOException ex) {
      LOGGER.warn("Error getting manifest for identifier " + identifier);
      throw new NotFoundException("No manifest for identifier " + identifier);
    }
    URI uri = resource.getUri();
    return getManifest(uri);
  }

  @Override
  public Manifest getManifest(URI manifestUri) throws NotFoundException {
    String location = manifestUri.toString();
    LOGGER.info("Trying to get manifest from " + location);

    try {
      Manifest manifest;
      String scheme = manifestUri.getScheme();

      // use caching for remote/http resources
      if ("http".equals(scheme)) {
        String cacheKey = location;
        manifest = httpCache.getIfPresent(cacheKey);
        if (manifest != null) {
          LOGGER.debug("HTTP Cache hit for manifest " + cacheKey);
          return manifest;
        }
      }

//      InputStream inputStream = resourceService.getInputStream(manifestUri);
//      manifest = objectMapper.readValue(inputStream, Manifest.class);
      String manifestJson = getManifestJson(manifestUri);
      manifest = objectMapper.readValue(manifestJson, Manifest.class);

      if ("http".equals(scheme)) {
        String cacheKey = location;
        httpCache.put(cacheKey, manifest);
      }

      return manifest;
    } catch (IOException ex) {
      LOGGER.warn("Error getting manifest from location " + location);
      throw new NotFoundException("No manifest for location: " + location);
    }
  }

  @Override
  public String getManifestJson(URI manifestUri) throws NotFoundException {
    try {
      InputStream inputStream = resourceService.getInputStream(manifestUri);
      String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
      LOGGER.debug("DONE getManifestJson() for " + manifestUri.toString());
      return json;
    } catch (IOException e) {
      throw new NotFoundException(e);
    }
  }

  @Override
  public JSONObject getManifestAsJsonObject(URI manifestUri) throws NotFoundException, ParseException {
    String json = getManifestJson(manifestUri);
    JSONParser parser = new JSONParser();
    Object obj = parser.parse(json);
    JSONObject jsonObject = (JSONObject) obj;
    return jsonObject;
  }

  @Override
  public JSONObject getManifestAsJsonObject(String manifestUri) throws URISyntaxException, NotFoundException, ParseException {
    return getManifestAsJsonObject(new URI(manifestUri));
  }
}
