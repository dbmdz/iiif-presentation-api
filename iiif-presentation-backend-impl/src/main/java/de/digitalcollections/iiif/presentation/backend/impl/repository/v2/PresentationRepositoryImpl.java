package de.digitalcollections.iiif.presentation.backend.impl.repository.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import de.digitalcollections.core.business.api.ResourceService;
import de.digitalcollections.core.model.api.MimeType;
import de.digitalcollections.core.model.api.resource.Resource;
import de.digitalcollections.core.model.api.resource.enums.ResourcePersistenceType;
import de.digitalcollections.core.model.api.resource.exceptions.ResourceIOException;
import de.digitalcollections.iiif.presentation.backend.api.exceptions.NotFoundException;
import de.digitalcollections.iiif.presentation.backend.api.repository.v2.PresentationRepository;
import de.digitalcollections.iiif.presentation.model.api.v2.Collection;
import de.digitalcollections.iiif.presentation.model.api.v2.Manifest;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
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

  private static final String COLLECTION_PREFIX = "collection-";
  private static final Logger LOGGER = LoggerFactory.getLogger(PresentationRepositoryImpl.class);

  private final Cache<String, Object> httpCache;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private ResourceService resourceService;

  public PresentationRepositoryImpl() {
    httpCache = CacheBuilder.newBuilder().maximumSize(32).build();
  }

  @Override
  public Collection getCollection(String name) throws NotFoundException {
    // to get a regex resolable pattern we add a static prefix for collections
    String collectionName = COLLECTION_PREFIX + name;

    Resource resource;
    try {
      resource = resourceService.get(collectionName, ResourcePersistenceType.REFERENCED, MimeType.MIME_APPLICATION_JSON);
    } catch (ResourceIOException ex) {
      LOGGER.warn("Error getting collection for name " + collectionName, ex);
      throw new NotFoundException("No collection for name " + collectionName);
    }
    URI uri = resource.getUri();
    return getCollection(uri);
  }

  @Override
  public Collection getCollection(URI collectionUri) throws NotFoundException {
    String location = collectionUri.toString();
    LOGGER.debug("Trying to get collection from " + location);

    try {
      Collection collection;
      String scheme = collectionUri.getScheme();

      // use caching for remote/http resources
      if ("http".equals(scheme)) {
        String cacheKey = location;
        collection = (Collection) httpCache.getIfPresent(cacheKey);
        if (collection != null) {
          LOGGER.debug("HTTP Cache hit for collection " + cacheKey);
          return collection;
        }
      }

//      InputStream inputStream = resourceService.getInputStream(manifestUri);
//      manifest = objectMapper.readValue(inputStream, Manifest.class);
      String collectionJson = getResourceJson(collectionUri);
      collection = objectMapper.readValue(collectionJson, Collection.class);

      if ("http".equals(scheme)) {
        String cacheKey = location;
        httpCache.put(cacheKey, collection);
      }

      return collection;
    } catch (IOException ex) {
      LOGGER.warn("Error getting collection from location " + location, ex);
      throw new NotFoundException("No collection for location: " + location);
    }
  }

  @Override
  public Manifest getManifest(String identifier) throws NotFoundException {
    Resource resource;
    try {
      resource = resourceService.get(identifier, ResourcePersistenceType.REFERENCED, MimeType.MIME_APPLICATION_JSON);
    } catch (ResourceIOException ex) {
      LOGGER.warn("Error getting manifest for identifier " + identifier, ex);
      throw new NotFoundException("No manifest for identifier " + identifier);
    }
    URI uri = resource.getUri();
    return getManifest(uri);
  }

  @Override
  public Manifest getManifest(URI manifestUri) throws NotFoundException {
    String location = manifestUri.toString();
    LOGGER.debug("Trying to get manifest from " + location);

    try {
      Manifest manifest;
      String scheme = manifestUri.getScheme();

      // use caching for remote/http resources
      if ("http".equals(scheme)) {
        String cacheKey = location;
        manifest = (Manifest) httpCache.getIfPresent(cacheKey);
        if (manifest != null) {
          LOGGER.debug("HTTP Cache hit for manifest " + cacheKey);
          return manifest;
        }
      }

//      InputStream inputStream = resourceService.getInputStream(manifestUri);
//      manifest = objectMapper.readValue(inputStream, Manifest.class);
      String manifestJson = getResourceJson(manifestUri);
      manifest = objectMapper.readValue(manifestJson, Manifest.class);

      if ("http".equals(scheme)) {
        String cacheKey = location;
        httpCache.put(cacheKey, manifest);
      }

      return manifest;
    } catch (IOException ex) {
      LOGGER.warn("Error getting manifest from location " + location, ex);
      throw new NotFoundException("No manifest for location: " + location);
    }
  }

  @Override
  public String getResourceJson(URI resourceUri) throws NotFoundException {
    try {
      InputStream inputStream = resourceService.getInputStream(resourceUri);
      String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
      LOGGER.debug("DONE getResourceJson() for " + resourceUri.toString());
      return json;
    } catch (IOException e) {
      throw new NotFoundException(e);
    }
  }

  @Override
  public JSONObject getResourceAsJsonObject(URI resourceUri) throws NotFoundException, ParseException {
    String json = getResourceJson(resourceUri);
    JSONParser parser = new JSONParser();
    Object obj = parser.parse(json);
    JSONObject jsonObject = (JSONObject) obj;
    return jsonObject;
  }

  @Override
  public JSONObject getResourceAsJsonObject(String resourceUri) throws NotFoundException, ParseException {
    return PresentationRepositoryImpl.this.getResourceAsJsonObject(URI.create(resourceUri));
  }
}
