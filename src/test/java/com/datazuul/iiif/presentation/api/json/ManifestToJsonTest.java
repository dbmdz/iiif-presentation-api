package com.datazuul.iiif.presentation.api.json;

import com.datazuul.iiif.presentation.api.model.Manifest;
import com.datazuul.iiif.presentation.api.model.other.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ralf Eichinger (ralf.eichinger at bsb-muenchen.de)
 */
public class ManifestToJsonTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(ManifestToJsonTest.class);

  static ObjectMapper objectMapper;

  @BeforeClass
  public static void setupClass() {
    objectMapper = new IiifPresentationApiObjectMapper();
  }

  @Test
  public void testManifestToJson() throws JsonProcessingException, URISyntaxException {
    Manifest manifest = new Manifest("testId", "testLabel");
    Thumbnail thumb = new Thumbnail();
    thumb.setId("http://example.com/iiif/test/thumb");
    Service service = new Service();
    service.setId("htp://example.com/iiif/test");
    thumb.setService(service);
    manifest.setThumbnail(thumb);
    String json = objectMapper.writeValueAsString(manifest);
    LOGGER.debug(json);
    Assert.assertTrue(json.contains("\"@id\":\"testId\""));
    Assert.assertTrue(json.contains("\"label\":\"testLabel\""));
    Assert.assertTrue(json.contains("\"@type\":\"sc:Manifest\""));
    Assert.assertTrue(json.contains("\"@context\":\"http://iiif.io/api/presentation/2/context.json\""));
  }

  @Test
  public void testMetadataSimpleToJson() throws JsonProcessingException {
    MetadataSimple metadata = new MetadataSimple("testLabel", "testValue");
    String json = objectMapper.writeValueAsString(metadata);
    LOGGER.debug(json);
    Assert.assertTrue(json.contains("\"label\":\"testLabel\""));
    Assert.assertTrue(json.contains("\"value\":\"testValue\""));
  }

  @Test
  public void testMetadataMultilanguageToJson() throws JsonProcessingException {
    List<MetadataLocalizedValue> values = new ArrayList<>();
    MetadataLocalizedValue valueGerman = new MetadataLocalizedValue("deutsch", Locale.GERMAN);
    MetadataLocalizedValue valueEnglish = new MetadataLocalizedValue("english", Locale.ENGLISH);
    values.add(valueGerman);
    values.add(valueEnglish);
    MetadataMultilanguage metadata = new MetadataMultilanguage("testLabel", values);
    String json = objectMapper.writeValueAsString(metadata);
    LOGGER.debug(json);
    Assert.assertTrue(json.contains("\"label\":\"testLabel\""));
    Assert.assertTrue(json.contains("{\"@value\":\"deutsch\",\"@language\":\"de\"}"));
    Assert.assertTrue(json.contains("{\"@value\":\"english\",\"@language\":\"en\"}"));
  }
}
