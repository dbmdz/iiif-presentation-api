package de.digitalcollections.iiif.presentation.model.impl.jackson;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.*;
import de.digitalcollections.iiif.presentation.model.impl.jackson.v2_0_0.IiifPresentationApiObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;


public class IiifPresentationApiObjectMapperTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(IiifPresentationApiObjectMapperTest.class);

  static ObjectMapper objectMapper;
  private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

  private static final String expectedMultiLanguageMetadataJson = "";

  @BeforeClass
  public static void setupClass() {
    objectMapper = new IiifPresentationApiObjectMapper();
  }

  @Test
  public void testJsonToMinimalManifest() throws JsonProcessingException, IOException, URISyntaxException {
    String json = IOUtils.
            toString(this.getClass().getClassLoader().getResourceAsStream("manifest_minimal.json"), DEFAULT_CHARSET);
    Manifest manifest = objectMapper.readValue(json, ManifestImpl.class);
    Assert.assertTrue(manifest.getId().equals(new URI("http://example.com/iiif/presentation/test-obj/manifest")));
    Assert.assertTrue(manifest.getLabel().getValue().equals("testLabel"));
    Assert.assertTrue(manifest.getType().equals("sc:Manifest"));
    Assert.assertTrue(manifest.getContext().equals("http://iiif.io/api/presentation/2/context.json"));
    assertEquals(manifest.getThumbnail().getId(),
            new URI("http://example.com/iiif/image/test-obj/full/200,/0/default.jpg"));
  }

  @Test
  public void testJsonToManifest() throws Exception {
    String json = IOUtils.
        toString(this.getClass().getClassLoader().getResourceAsStream("manifest.json"), DEFAULT_CHARSET);
    Manifest manifest = objectMapper.readValue(json, ManifestImpl.class);
    Assert.assertNotNull(manifest.getMetadata());
  }

  @Test
  public void testJsonToMetadata() throws JsonProcessingException, IOException, URISyntaxException {
    String json = IOUtils.
            toString(this.getClass().getClassLoader().getResourceAsStream("manifest_metadata.json"), DEFAULT_CHARSET);
    Manifest manifest = objectMapper.readValue(json, ManifestImpl.class);
    Assert.assertTrue(manifest.getId().equals(new URI("http://example.com/iiif/presentation/test-obj/manifest")));
    Assert.assertEquals("testLabel", manifest.getLabel().getValue());
    Assert.assertTrue(manifest.getType().equals("sc:Manifest"));
    Assert.assertTrue(manifest.getContext().equals("http://iiif.io/api/presentation/2/context.json"));
    Assert.assertNotNull(manifest.getMetadata());
  }

  @Test
  public void testManifestToJson() throws JsonProcessingException, URISyntaxException {
    Manifest manifest = new ManifestImpl("testId", new PropertyValueSimpleImpl("testLabel"));
    Thumbnail thumb = new ThumbnailImpl();
    thumb.setId(new URI("http://example.com/iiif/test/thumb"));
    Service service = new ServiceImpl();
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
    MetadataImpl metadata = new MetadataImpl(new PropertyValueSimpleImpl("testLabel"),
                                             new PropertyValueSimpleImpl("testValue"));
    String json = objectMapper.writeValueAsString(metadata);
    LOGGER.debug(json);
    Assert.assertTrue(json.contains("\"label\":\"testLabel\""));
    Assert.assertTrue(json.contains("\"value\":\"testValue\""));
  }

  @Test
  public void testMetadataMultilanguageToJson() throws JsonProcessingException {
    PropertyValueLocalizedImpl labelProp = new PropertyValueLocalizedImpl();
    PropertyValueLocalizedImpl valueProp = new PropertyValueLocalizedImpl();

    labelProp.setValue(Locale.GERMAN, "Deutscher Schlüssel");
    valueProp.setValue(Locale.GERMAN, "Deutscher Wert");

    labelProp.setValue(Locale.ENGLISH, "English Key");
    valueProp.setValue(Locale.ENGLISH, "English Value");

    Metadata metadata = new MetadataImpl(labelProp, valueProp);
    String jsonString = objectMapper.writeValueAsString(metadata);
    ReadContext ctx = JsonPath.parse(jsonString);
    assertEquals(ctx.read("$.label.size()", Integer.class), new Integer(2));
    assertEquals(ctx.read("$.value.size()", Integer.class), new Integer(2));
    // TODO: More asserts
  }
}
