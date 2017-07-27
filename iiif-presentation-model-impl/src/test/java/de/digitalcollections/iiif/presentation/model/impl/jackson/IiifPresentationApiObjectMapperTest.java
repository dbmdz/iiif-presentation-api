package de.digitalcollections.iiif.presentation.model.impl.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import com.revinate.assertj.json.JsonPathAssert;
import de.digitalcollections.iiif.presentation.model.api.v2.*;
import de.digitalcollections.iiif.presentation.model.api.v2.references.CollectionReference;
import de.digitalcollections.iiif.presentation.model.api.v2.references.ManifestReference;
import de.digitalcollections.iiif.presentation.model.impl.jackson.v2.IiifPresentationApiObjectMapper;
import de.digitalcollections.iiif.presentation.model.impl.v2.*;
import de.digitalcollections.iiif.presentation.model.impl.v2.references.CollectionReferenceImpl;
import de.digitalcollections.iiif.presentation.model.impl.v2.references.ManifestReferenceImpl;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
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
  public void testJsonToMinimalManifest() throws JsonProcessingException, IOException {
    String json = IOUtils.
            toString(this.getClass().getClassLoader().getResourceAsStream("manifest_minimal.json"), DEFAULT_CHARSET);
    Manifest manifest = objectMapper.readValue(json, ManifestImpl.class);
    Assert.assertTrue(manifest.getId().equals(URI.create("http://example.com/iiif/presentation/test-obj/manifest")));
    PropertyValueLocalizedImpl manifestLabel = (PropertyValueLocalizedImpl) manifest.getLabel();
    Assert.assertTrue(manifestLabel.getValues("en").get(0).equals("testLabel"));
    Assert.assertTrue(manifestLabel.getValues("de").get(0).equals("täschtLäibel"));
    Assert.assertTrue(manifest.getType().equals("sc:Manifest"));
    Assert.assertTrue(manifest.getContext().equals("http://iiif.io/api/presentation/2/context.json"));
    assertEquals(manifest.getThumbnail().getId(),
            URI.create("http://example.com/iiif/image/test-obj/full/200,/0/default.jpg"));
  }

  @Test
  public void testJsonToCollection() throws JsonProcessingException, IOException {
    String json = IOUtils.
            toString(this.getClass().getClassLoader().getResourceAsStream("collection.json"), DEFAULT_CHARSET);
    Collection collection = objectMapper.readValue(json, CollectionImpl.class);
    Assert.assertTrue(collection.getId().equals(
            URI.create("https://api.digitale-sammlungen.de/iiif/presentation/v2/collection/bsbmult00000001")));

    PropertyValueLocalizedImpl label = (PropertyValueLocalizedImpl) collection.getLabel();
    Assert.assertTrue(label.getValues("de").get(0).equals("Der gerade Weg"));

    Assert.assertTrue(collection.getType().equals("sc:Collection"));
  }

  @Test
  public void testJsonToMetadata() throws JsonProcessingException, IOException {
    String json = IOUtils.
            toString(this.getClass().getClassLoader().getResourceAsStream("manifest_metadata.json"), DEFAULT_CHARSET);
    Manifest manifest = objectMapper.readValue(json, ManifestImpl.class);
    Assert.assertTrue(manifest.getId().equals(URI.create("http://example.com/iiif/presentation/test-obj/manifest")));
    Assert.assertEquals("testLabel", manifest.getLabel().getValues().get(0));
    Assert.assertTrue(manifest.getType().equals("sc:Manifest"));
    Assert.assertTrue(manifest.getContext().equals("http://iiif.io/api/presentation/2/context.json"));
    Assert.assertNotNull(manifest.getMetadata());
  }

  @Test
  public void testJsonToFullFledgedMetadata() throws IOException {
    String json = IOUtils.
            toString(this.getClass().getClassLoader().getResourceAsStream("manifest.json"), DEFAULT_CHARSET);
    Manifest manifest = objectMapper.readValue(json, ManifestImpl.class);
    PropertyValueLocalizedImpl description = (PropertyValueLocalizedImpl) manifest.getDescription();
    Assert.assertTrue(description.getValues(Locale.GERMAN).get(0).startsWith("303. Bändchen"));
    Assert
            .assertEquals("Die Mechanik der festen, flüssigen und gasförmigen Körper; 1. Teil; Die Mechanik der festen Körper",
                    manifest.getLabel().getValues().get(0));
    Sequence sequence = manifest.getSequences().get(0);
    Assert.assertEquals("Current Page Order", sequence.getLabel().getValues().get(0));
    PropertyValueLocalizedImpl firstCanvasLabel = (PropertyValueLocalizedImpl) sequence.getCanvases().get(0).getLabel();
    Assert.assertEquals("Umschlag vorne", firstCanvasLabel.getValues(Locale.GERMAN).get(0));
    Assert.assertEquals("Front Cover", firstCanvasLabel.getValues(Locale.ENGLISH).get(0));
    Assert.assertEquals("Umschlag vorne", firstCanvasLabel.getValues().get(0));
    Assert.assertEquals("http://some-url.org/some-search-api", manifest.getServices().get(0).getId().toString());
  }

  @Test
  public void testManifestToJson() throws JsonProcessingException {
    Manifest manifest = new ManifestImpl("testId", new PropertyValueSimpleImpl("testLabel"));
    Thumbnail thumb = new ThumbnailImpl();
    thumb.setId(URI.create("http://example.com/iiif/test/thumb"));
    Service service = new ServiceImpl();
    service.setId("htp://example.com/iiif/test");
    thumb.setService(service);
    manifest.setThumbnail(thumb);
    String jsonString = objectMapper.writeValueAsString(manifest);
    ReadContext ctx = JsonPath.parse(jsonString);
    Assert.assertEquals("testId", ctx.read("$['@id']"));
    Assert.assertEquals("testLabel", ctx.read("$.label"));
    Assert.assertEquals("http://iiif.io/api/presentation/2/context.json", ctx.read("$['@context']"));
    Assert.assertEquals("sc:Manifest", ctx.read("$['@type']"));
  }

  @Test
  public void testMetadataSimpleToJson() throws JsonProcessingException {
    MetadataImpl metadata = new MetadataImpl(new PropertyValueSimpleImpl("testLabel"),
            new PropertyValueSimpleImpl("testValue"));
    String jsonString = objectMapper.writeValueAsString(metadata);
    ReadContext ctx = JsonPath.parse(jsonString);
    Assert.assertEquals("testLabel", ctx.read("$.label"));
    Assert.assertEquals("testValue", ctx.read("$.value"));
  }

  @Test
  public void testMetadataMultilanguageToJson() throws JsonProcessingException {
    PropertyValueLocalizedImpl labelProp = new PropertyValueLocalizedImpl();
    PropertyValueLocalizedImpl valueProp = new PropertyValueLocalizedImpl();

    labelProp.addValue(Locale.GERMAN, "Deutscher Schlüssel");
    valueProp.addValue(Locale.GERMAN, "Deutscher Wert");

    labelProp.addValue(Locale.ENGLISH, "English Key");
    valueProp.addValue(Locale.ENGLISH, "English Value");

    Metadata metadata = new MetadataImpl(labelProp, valueProp);
    String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(metadata);
    LOGGER.debug(jsonString);
    ReadContext ctx = JsonPath.parse(jsonString);
    Assert.assertEquals(new Long(2), ctx.read("$.label.size()", Long.class));
    Assert.assertEquals(new Long(2), ctx.read("$.value.size()", Long.class));
    String[] germanKey = ctx.read("$.label[?(@['@language']=='de')]['@value']", String[].class);
    Assert.assertEquals("Deutscher Schlüssel", germanKey[0]);
    String[] englishKey = ctx.read("$.label[?(@['@language']=='en')]['@value']", String[].class);
    Assert.assertEquals("English Key", englishKey[0]);
  }

  @Test
  public void testCollectionToJson() throws JsonProcessingException {
    PropertyValue labelProp = new PropertyValueSimpleImpl("some label");
    List<Metadata> metadata = new ArrayList<>();
    metadata.add(new MetadataImpl(new PropertyValueSimpleImpl("some key"), new PropertyValueSimpleImpl("some value")));
    Collection coll = new CollectionImpl(URI.create("http://example.com/collection/some-collection"), labelProp, metadata);

    List<ManifestReference> manifests = new ArrayList<>();
    manifests.add(new ManifestReferenceImpl(URI.create("http://example.com/manifest/some-manifest"),
            new PropertyValueSimpleImpl("some label")));
    manifests.add(new ManifestReferenceImpl(URI.create("http://example.com/manifest/some-other-manifest")));
    coll.setManifests(manifests);

    List<CollectionReference> subColls = new ArrayList<>();
    subColls.add(new CollectionReferenceImpl(URI.create("http://example.com/collection/some-other-collection"),
            new PropertyValueSimpleImpl("some label")));
    subColls.add(new CollectionReferenceImpl(URI.create("http://example.com/collection/yet-another-collection")));
    coll.setSubCollections(subColls);
    String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(coll);
    DocumentContext ctx = JsonPath.parse(jsonString);
    JsonPathAssert.assertThat(ctx).jsonPathAsInteger("$.collections.length()").isEqualTo(2);
    JsonPathAssert.assertThat(ctx).jsonPathAsInteger("$.manifests.length()").isEqualTo(2);
    JsonPathAssert.assertThat(ctx).jsonPathAsString("$.label").isEqualTo("some label");
    JsonPathAssert.assertThat(ctx).jsonPathAsString("$.metadata[0].label").isEqualTo("some key");
    JsonPathAssert.assertThat(ctx).jsonPathAsString("$.manifests[0]['@type']").isEqualTo("sc:Manifest");
    JsonPathAssert.assertThat(ctx).jsonPathAsString("$.collections[0]['@type']").isEqualTo("sc:Collection");
  }

  @Test
  public void testSeeAlsoToJson() throws JsonProcessingException {
    SeeAlso seeAlso = new SeeAlsoImpl();
    seeAlso.setId(URI.create("http://example.com/test"));
    seeAlso.setFormat("application/json");
    seeAlso.setProfile(URI.create("http://example.com/profile"));
    String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(seeAlso);
    DocumentContext ctx = JsonPath.parse(json);
    JsonPathAssert.assertThat(ctx).jsonPathAsString("$['@id']").isEqualTo("http://example.com/test");
    JsonPathAssert.assertThat(ctx).jsonPathAsString("$.format").isEqualTo("application/json");
    JsonPathAssert.assertThat(ctx).jsonPathAsString("$.profile").isEqualTo("http://example.com/profile");
  }

  @Test
  public void testSeeAlsoFromJson() throws IOException {
    String json = IOUtils.
            toString(this.getClass().getClassLoader().getResourceAsStream("manifest_seealso.json"), DEFAULT_CHARSET);
    Manifest manifest = objectMapper.readValue(json, ManifestImpl.class);
    assertThat(manifest.getSeeAlso()).hasSize(2);
    assertThat(manifest.getSeeAlso().get(0).getFormat()).isEqualTo("application/json");
    assertThat(manifest.getSeeAlso().get(0).getProfile().toASCIIString()).
            isEqualTo("http://iiif.io/some-new-api/profile");
    assertThat(manifest.getSeeAlso().get(1).getFormat()).isNull();
  }

  @Test
  public void testBroken() throws IOException {
    String json = IOUtils.
            toString(this.getClass().getClassLoader().getResourceAsStream("broken.json"), DEFAULT_CHARSET);
    Manifest manifest = objectMapper.readValue(json, Manifest.class);
    assertThat(manifest.getLabel()).isNotNull();
  }

  @Test
  public void testBsb10505590() throws IOException {
    String json = IOUtils.
            toString(this.getClass().getClassLoader().getResourceAsStream("manifest_bsb10505590.json"), DEFAULT_CHARSET);
    Manifest manifest = objectMapper.readValue(json, Manifest.class);
    assertThat(manifest.getLabel()).isNotNull();
  }

  @Test
  public void testReadNavDate() throws IOException {
    String json = IOUtils.
            toString(this.getClass().getClassLoader().getResourceAsStream("navdate.json"), DEFAULT_CHARSET);
    Manifest manifest = objectMapper.readValue(json, Manifest.class);
    LocalDateTime ldt = LocalDateTime.ofInstant(manifest.getNavDate(), ZoneId.systemDefault());
    assertThat(ldt.getYear()).isEqualTo(1848);
    assertThat(ldt.getMonthValue()).isEqualTo(1);
    assertThat(ldt.getDayOfMonth()).isEqualTo(1);
  }

  @Test
  public void testWriteNavDate() throws IOException {
    Manifest manifest = new ManifestImpl("testId", new PropertyValueSimpleImpl("testLabel"));
    manifest.setNavDate(LocalDateTime.of(1789, 7, 14, 12, 0).toInstant(ZoneOffset.UTC));
    String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(manifest);
    DocumentContext ctx = JsonPath.parse(json);
    JsonPathAssert.assertThat(ctx).jsonPathAsString("$['navDate']").isEqualTo("1789-07-14T12:00:00Z");
  }

  @Test
  public void testAddPhysicalDimensionsService() throws IOException {
    ImageService imageService = new ImageServiceImpl();
    imageService.setContext("http://iiif.io/api/image/2/context.json");
    imageService.setProfile("http://iiif.io/api/image/2/level1.json");
    imageService.setId("http://some.url.org");
    Image image = new ImageImpl("http://foo.org");
    image.setResource(new ImageResourceImpl("http://someresource.io"));
    image.getResource().setService(imageService);
    image.getResource().setHeight(100);
    image.getResource().setWidth(100);
    image.setOn(URI.create("http://foo.org"));
    List<Image> images = Collections.singletonList(image);
    Canvas canvas = new CanvasImpl(URI.create("http://dummy.org/canvas"), new PropertyValueSimpleImpl("dummy"), 800, 600);
    canvas.setImages(images);
    List<Service> services = new ArrayList();
    services.add(new PhysicalDimensionsServiceImpl(0.025, "in"));
    canvas.setServices(services);
    String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(canvas);
    DocumentContext ctx = JsonPath.parse(json);
    JsonPathAssert.assertThat(ctx).jsonPathAsString("$.service.physicalUnits").isEqualTo("in");
    JsonPathAssert.assertThat(ctx).jsonPathAsString("$.images[0].resource.service.profile").isEqualTo("http://iiif.io/api/image/2/level1.json");
    Canvas deserialized = objectMapper.readValue(json, Canvas.class);
    assertThat(deserialized.getServices().get(0).getProfile()).contains("physdim");
    assertThat(((PhysicalDimensionsServiceImpl) deserialized.getServices().get(0)).getPhysicalUnits()).isEqualTo("in");
  }

  @Test
  public void testParseServices() throws IOException {
    String json = IOUtils.
        toString(this.getClass().getClassLoader().getResourceAsStream("manifest_services.json"), DEFAULT_CHARSET);
    Manifest manifest = objectMapper.readValue(json, Manifest.class);
    assertThat(manifest.getServices()).hasSize(2);
    assertThat(manifest.getSequences().get(0).getCanvases().get(0).getServices()).hasSize(2);
    assertThat(manifest.getSequences().get(0).getCanvases().get(1).getImages().get(0).getResource().getServices()).hasSize(2);
  }

  @Test
  public void testCreateThumbnail() throws JsonProcessingException {
    ImageService service = new ImageServiceImpl();
    service.setWidth(640);
    service.setHeight(480);
    service.setProfile("http://some/profile");
    service.setId("http://example.com");
    Thumbnail thumb = new ThumbnailImpl();
    thumb.setId(URI.create("http://foobar.org"));
    thumb.setService(service);
    String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(thumb);
    DocumentContext ctx = JsonPath.parse(json);
    JsonPathAssert.assertThat(ctx).jsonPathAsString("$.service.width").isEqualTo("640");
  }
}
