package com.datazuul.iiif.presentation.api.json;

import com.datazuul.iiif.presentation.api.model.Manifest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ralf Eichinger (ralf.eichinger at bsb-muenchen.de)
 */
public class JsonToManifestTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(JsonToManifestTest.class);

  static ObjectMapper objectMapper;

  @BeforeClass
  public static void setupClass() {
    objectMapper = new IiifPresentationApiObjectMapper();
  }

  @Test
  public void testJsonToManifest() throws JsonProcessingException, IOException {
    String json = "{\"@id\":\"testId\","
            + "\"label\":\"testLabel\","
            + "\"@type\":\"sc:Manifest\","
            + "\"@context\":\"http://iiif.io/api/presentation/2/context.json\"}";
    Manifest manifest = objectMapper.readValue(json, Manifest.class);
    Assert.assertTrue(manifest.getId().equals("testId"));
    Assert.assertTrue(manifest.getLabel().equals("testLabel"));
    Assert.assertTrue(manifest.getType().equals("sc:Manifest"));
    Assert.assertTrue(manifest.getContext().equals("http://iiif.io/api/presentation/2/context.json"));
  }

  @Test
  public void testJsonToMetadata() throws JsonProcessingException, IOException {
    String json = "{"
            + "\"@id\":\"testId\","
            + "\"label\":\"testLabel\","
            + "\"@type\":\"sc:Manifest\","
            + "\"@context\":\"http://iiif.io/api/presentation/2/context.json\","
            + "\"metadata\": ["
            + "    {\"label\":\"Author\", \"value\":\"Anne Author\"},"
            + "    {\"label\":\"Published\", \"value\": ["
            + "        {\"@value\": \"Paris, circa 1400\", \"@language\":\"en\"},"
            + "        {\"@value\": \"Paris, environ 14eme siecle\", \"@language\":\"fr\"}"
            + "        ]"
            + "    }"
            + "  ]"
            + "}";
    Manifest manifest = objectMapper.readValue(json, Manifest.class);
    Assert.assertTrue(manifest.getId().equals("testId"));
    Assert.assertTrue(manifest.getLabel().equals("testLabel"));
    Assert.assertTrue(manifest.getType().equals("sc:Manifest"));
    Assert.assertTrue(manifest.getContext().equals("http://iiif.io/api/presentation/2/context.json"));

    Assert.assertNotNull(manifest.getMetadata());
  }
}
