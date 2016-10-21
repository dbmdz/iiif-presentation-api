package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import de.digitalcollections.iiif.presentation.model.api.enums.AnnotationMotivation;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Annotation;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.AnnotationList;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.AnnotationResourceChars;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Canvas;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Manifest;
import de.digitalcollections.iiif.presentation.model.impl.jackson.v2_0_0.IiifPresentationApiObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnnotationsTest {

  static ObjectMapper objectMapper;
  private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

  public AnnotationsTest() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
  }

  @BeforeClass
  public static void setupClass() {
    objectMapper = new IiifPresentationApiObjectMapper();
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testReadingAnnotationList() throws IOException {
    String json = IOUtils.
            toString(this.getClass().getClassLoader().getResourceAsStream("annotationList.json"), DEFAULT_CHARSET);
    AnnotationList annotationList = objectMapper.readValue(json, AnnotationListImpl.class);

    // check attribute values
    Assert.assertEquals("http://iiif.io/api/presentation/2/context.json", annotationList.getContext());
    Assert.assertEquals("http://dev.llgc.org.uk/iiif/examples/newspapers/3100187-anno.json", annotationList.getId().toString());
    Assert.assertEquals("sc:AnnotationList", annotationList.getType());

    // check resources
    Assert.assertTrue(annotationList.getResources().size() == 2);

    // check first annotation values
    final Annotation firstAnnotation = annotationList.getResources().get(0);
    Assert.assertEquals("oa:Annotation", firstAnnotation.getType());
    Assert.assertEquals(AnnotationMotivation.PAINTING.getValue(), firstAnnotation.getMotivation());
    Assert.assertEquals("http://dams.llgc.org.uk/iiif/3100186/canvas/3100187#xywh=546,993,491,42", firstAnnotation.getOn().toString());

    // check resource of first annotation
    AnnotationResourceCharsImpl annotationResource = (AnnotationResourceCharsImpl) firstAnnotation.getResource();
    Assert.assertEquals("cnt:ContentAsText", annotationResource.getType());
    Assert.assertEquals("text/plain", annotationResource.getFormat());
    Assert.assertEquals("MR. JAMES RIBBON,", annotationResource.getChars());
  }

  @Test
  public void testWritingAnnotationList() throws URISyntaxException, JsonProcessingException {
    AnnotationList al = createAnnotationList();

    // annotationlist resources
    List<Annotation> annotations = new ArrayList<>();
    Annotation annotation1 = createAnnotation();
    annotations.add(annotation1);
    al.setResources(annotations);

    String jsonString = objectMapper.writeValueAsString(al);
    ReadContext ctx = JsonPath.parse(jsonString);
    Assert.assertEquals("http://iiif.io/api/presentation/2/context.json", ctx.read("$['@context']"));
    Assert.assertEquals("http://dev.llgc.org.uk/iiif/examples/newspapers/3100187-anno.json", ctx.read("$['@id']"));
    Assert.assertEquals("sc:AnnotationList", ctx.read("$['@type']"));

    String on = ctx.read("$.resources[0].on");
    Assert.assertEquals("http://dams.llgc.org.uk/iiif/3100186/canvas/3100187#xywh=546,993,491,42", on);

    String chars = ctx.read("$.resources[0].resource.chars");
    Assert.assertEquals("MR. JAMES RIBBON,", chars);
  }

  public AnnotationList createAnnotationList() throws URISyntaxException {
    AnnotationList al = new AnnotationListImpl("http://dev.llgc.org.uk/iiif/examples/newspapers/3100187-anno.json");
    return al;
  }

  public Annotation createAnnotation() throws URISyntaxException {
    Annotation annotation1 = new AnnotationImpl(AnnotationMotivation.PAINTING.getValue());
    annotation1.setOn(new URI("http://dams.llgc.org.uk/iiif/3100186/canvas/3100187#xywh=546,993,491,42"));
    AnnotationResourceChars resource1 = new AnnotationResourceCharsImpl("cnt:ContentAsText", "text/plain");
    resource1.setChars("MR. JAMES RIBBON,");
    annotation1.setResource(resource1);
    return annotation1;
  }

  @Test
  public void testReadingManifestWithAnnotationLists() throws IOException {
    String json = IOUtils.
            toString(this.getClass().getClassLoader().getResourceAsStream("manifest_annotationLists.json"), DEFAULT_CHARSET);
    Manifest manifest = objectMapper.readValue(json, ManifestImpl.class);
    Canvas canvas1 = manifest.getSequences().get(0).getCanvases().get(0);
    Assert.assertTrue(canvas1.getOtherContent().size() == 1);

    Canvas canvas2 = manifest.getSequences().get(0).getCanvases().get(1);
    Assert.assertTrue(canvas2.getOtherContent().size() == 4);
  }

  @Test(expected = JsonMappingException.class)
  public void testReadingManifestWithInvalidAnnotationLists() throws IOException {
    String json = IOUtils.
            toString(this.getClass().getClassLoader().getResourceAsStream("manifest_annotationListsInvalid.json"), DEFAULT_CHARSET);
    objectMapper.readValue(json, ManifestImpl.class);
  }

  @Test
  public void testWritingManifestWithAnnotationLists() throws URISyntaxException, JsonProcessingException {
    Manifest manifest = new ManifestImpl("http://www.example.org/1/manifest", new PropertyValueSimpleImpl("manifestlabel"));
    
    // FIXME add tests for canvas annotation list
    
    String jsonString = objectMapper.writeValueAsString(manifest);
    Assert.assertTrue(manifest.getLabel() != null);
  }
}
