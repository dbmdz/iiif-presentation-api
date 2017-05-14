package de.digitalcollections.iiif.presentation.backend.impl.repository.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import de.digitalcollections.core.business.api.ResourceService;
import de.digitalcollections.core.model.api.MimeType;
import de.digitalcollections.core.model.api.resource.Resource;
import de.digitalcollections.core.model.api.resource.enums.ResourcePersistenceType;
import de.digitalcollections.core.model.api.resource.exceptions.ResourceIOException;
import de.digitalcollections.iiif.presentation.model.api.exceptions.InvalidDataException;
import de.digitalcollections.iiif.presentation.model.api.exceptions.NotFoundException;
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
  public Collection getCollection(String name) throws NotFoundException, InvalidDataException {
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
  public Collection getCollection(URI collectionUri) throws NotFoundException, InvalidDataException {
    String location = collectionUri.toString();
    LOGGER.debug("Trying to get collection from " + location);

    Collection collection;
    String scheme = collectionUri.getScheme();

    // use caching for remote/http resources
    if ("http".equals(scheme)) {
      collection = (Collection) httpCache.getIfPresent(location);
      if (collection != null) {
        LOGGER.debug("HTTP Cache hit for collection " + location);
        return collection;
      }
    }

    String collectionJson = getResourceJson(collectionUri);
    try {
      collection = objectMapper.readValue(collectionJson, Collection.class);
    } catch (IOException e) {
      throw new InvalidDataException("Error reading from JSON", e);
    }

    if ("http".equals(scheme)) {
      httpCache.put(location, collection);
    }

    return collection;
  }

  @Override
  public Manifest getManifest(String identifier) throws NotFoundException, InvalidDataException {
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
  public Manifest getManifest(URI manifestUri) throws NotFoundException, InvalidDataException {
    String location = manifestUri.toString();
    LOGGER.debug("Trying to get manifest from " + location);

    Manifest manifest;
    String scheme = manifestUri.getScheme();

    // use caching for remote/http resources
    if ("http".equals(scheme)) {
      manifest = (Manifest) httpCache.getIfPresent(location);
      if (manifest != null) {
        LOGGER.debug("HTTP Cache hit for manifest " + location);
        return manifest;
      }
    }

    String manifestJson = getResourceJson(manifestUri);
    try {
      manifest = objectMapper.readValue(manifestJson, Manifest.class);
    } catch (IOException e) {
      throw new InvalidDataException("Could not read manifest JSON", e);
    }

    if ("http".equals(scheme)) {
      httpCache.put(location, manifest);
    }

    return manifest;
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
    return (JSONObject) obj;
  }

  @Override
  public JSONObject getResourceAsJsonObject(String resourceUri) throws NotFoundException, ParseException {
    return this.getResourceAsJsonObject(URI.create(resourceUri));
  }
}
