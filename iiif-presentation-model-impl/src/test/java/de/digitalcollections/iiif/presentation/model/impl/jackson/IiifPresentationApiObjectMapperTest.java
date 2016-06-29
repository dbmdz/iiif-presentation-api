package de.digitalcollections.iiif.presentation.model.impl.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.iiif.presentation.model.api.Manifest;
import de.digitalcollections.iiif.presentation.model.api.Service;
import de.digitalcollections.iiif.presentation.model.api.Thumbnail;
import de.digitalcollections.iiif.presentation.model.impl.ManifestImpl;
import de.digitalcollections.iiif.presentation.model.impl.MetadataLocalizedValueImpl;
import de.digitalcollections.iiif.presentation.model.impl.MetadataMultilanguageImpl;
import de.digitalcollections.iiif.presentation.model.impl.MetadataSimpleImpl;
import de.digitalcollections.iiif.presentation.model.impl.ServiceImpl;
import de.digitalcollections.iiif.presentation.model.impl.ThumbnailImpl;
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

public class IiifPresentationApiObjectMapperTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(IiifPresentationApiObjectMapperTest.class);

  static ObjectMapper objectMapper;
  private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

  @BeforeClass
  public static void setupClass() {
    objectMapper = new IiifPresentationApiObjectMapper();
  }

  @Test
  public void testJsonToManifest() throws JsonProcessingException, IOException, URISyntaxException {
    String json = IOUtils.
            toString(this.getClass().getClassLoader().getResourceAsStream("manifest_minimal.json"), DEFAULT_CHARSET);
    Manifest manifest = objectMapper.readValue(json, ManifestImpl.class);
    Assert.assertTrue(manifest.getId().equals(new URI("http://example.com/iiif/presentation/test-obj/manifest")));
    Assert.assertTrue(manifest.getLabel().equals("testLabel"));
    Assert.assertTrue(manifest.getType().equals("sc:Manifest"));
    Assert.assertTrue(manifest.getContext().equals("http://iiif.io/api/presentation/2/context.json"));
    Assert.assertEquals(manifest.getThumbnail().getId(),
            new URI("http://example.com/iiif/image/test-obj/full/200,/0/default.jpg"));
  }

  @Test
  public void testJsonToMetadata() throws JsonProcessingException, IOException, URISyntaxException {
    String json = IOUtils.
            toString(this.getClass().getClassLoader().getResourceAsStream("manifest_metadata.json"), DEFAULT_CHARSET);
    Manifest manifest = objectMapper.readValue(json, ManifestImpl.class);
    Assert.assertTrue(manifest.getId().equals(new URI("http://example.com/iiif/presentation/test-obj/manifest")));
    Assert.assertTrue(manifest.getLabel().equals("testLabel"));
    Assert.assertTrue(manifest.getType().equals("sc:Manifest"));
    Assert.assertTrue(manifest.getContext().equals("http://iiif.io/api/presentation/2/context.json"));

    Assert.assertNotNull(manifest.getMetadata());
  }

  @Test
  public void testManifestToJson() throws JsonProcessingException, URISyntaxException {
    Manifest manifest = new ManifestImpl("testId", "testLabel");
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
    MetadataSimpleImpl metadata = new MetadataSimpleImpl("testLabel", "testValue");
    String json = objectMapper.writeValueAsString(metadata);
    LOGGER.debug(json);
    Assert.assertTrue(json.contains("\"label\":\"testLabel\""));
    Assert.assertTrue(json.contains("\"value\":\"testValue\""));
  }

  @Test
  public void testMetadataMultilanguageToJson() throws JsonProcessingException {
    List<MetadataLocalizedValueImpl> values = new ArrayList<>();
    MetadataLocalizedValueImpl valueGerman = new MetadataLocalizedValueImpl("deutsch", Locale.GERMAN);
    MetadataLocalizedValueImpl valueEnglish = new MetadataLocalizedValueImpl("english", Locale.ENGLISH);
    values.add(valueGerman);
    values.add(valueEnglish);
    MetadataMultilanguageImpl metadata = new MetadataMultilanguageImpl("testLabel", values);
    String json = objectMapper.writeValueAsString(metadata);
    LOGGER.debug(json);
    Assert.assertTrue(json.contains("\"label\":\"testLabel\""));
    Assert.assertTrue(json.contains("{\"@value\":\"deutsch\",\"@language\":\"de\"}"));
    Assert.assertTrue(json.contains("{\"@value\":\"english\",\"@language\":\"en\"}"));
  }
}
