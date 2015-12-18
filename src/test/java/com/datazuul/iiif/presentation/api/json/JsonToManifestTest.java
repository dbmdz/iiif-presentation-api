package com.datazuul.iiif.presentation.api.json;

import com.datazuul.iiif.presentation.api.model.Manifest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
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
  public void testJsonToManifest() throws JsonProcessingException, IOException, URISyntaxException {
    String json = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream("manifest_minimal.json"));
    Manifest manifest = objectMapper.readValue(json, Manifest.class);
    Assert.assertTrue(manifest.getId().equals("testId"));
    Assert.assertTrue(manifest.getLabel().equals("testLabel"));
    Assert.assertTrue(manifest.getType().equals("sc:Manifest"));
    Assert.assertTrue(manifest.getContext().equals("http://iiif.io/api/presentation/2/context.json"));
    Assert.assertEquals(manifest.getThumbnail().getId(),
                        new URI("http://example.com/iiif/image/test-obj/full/200,/0/default.jpg"));
  }

  @Test
  public void testJsonToMetadata() throws JsonProcessingException, IOException, URISyntaxException {
    String json = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream("manifest_metadata.json"));
    Manifest manifest = objectMapper.readValue(json, Manifest.class);
    Assert.assertTrue(manifest.getId().equals("testId"));
    Assert.assertTrue(manifest.getLabel().equals("testLabel"));
    Assert.assertTrue(manifest.getType().equals("sc:Manifest"));
    Assert.assertTrue(manifest.getContext().equals("http://iiif.io/api/presentation/2/context.json"));

    Assert.assertNotNull(manifest.getMetadata());
  }
}
