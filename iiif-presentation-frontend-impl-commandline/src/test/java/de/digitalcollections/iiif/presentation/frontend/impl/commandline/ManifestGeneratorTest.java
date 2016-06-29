package de.digitalcollections.iiif.presentation.frontend.impl.commandline;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.digitalcollections.iiif.presentation.model.api.Canvas;
import de.digitalcollections.iiif.presentation.model.api.Image;
import de.digitalcollections.iiif.presentation.model.api.ImageResource;
import de.digitalcollections.iiif.presentation.model.api.Manifest;
import de.digitalcollections.iiif.presentation.model.api.Sequence;
import de.digitalcollections.iiif.presentation.model.api.Service;
import de.digitalcollections.iiif.presentation.model.impl.CanvasImpl;
import de.digitalcollections.iiif.presentation.model.impl.ImageImpl;
import de.digitalcollections.iiif.presentation.model.impl.ImageResourceImpl;
import de.digitalcollections.iiif.presentation.model.impl.ManifestImpl;
import de.digitalcollections.iiif.presentation.model.impl.SequenceImpl;
import de.digitalcollections.iiif.presentation.model.impl.ServiceImpl;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ManifestGeneratorTest {

  public ManifestGeneratorTest() {
  }

  @Test
  public void testGenerateJson() throws JsonProcessingException, URISyntaxException {
    String urlPrefix = "http://localhost:10000/de.alexandria.webapp";
    Manifest manifest = new ManifestImpl(new URI(urlPrefix + "/demo/bookreader/manifest.json"), "Walters MS 168");

    List<Sequence> sequences = new ArrayList<>();
    manifest.setSequences(sequences);

    Sequence seq1 = new SequenceImpl("Current page order");
    seq1.setId(urlPrefix + "/demo/bookreader/normal");
    sequences.add(seq1);

    List<Canvas> canvases = new ArrayList<>();
    seq1.setCanvases(canvases);

    addPage(urlPrefix, canvases);

    ManifestGenerator mg = new ManifestGenerator();
    String json = mg.generateJson(manifest);
    System.out.println(json);
    Assert.assertTrue(json.contains("{"));
  }

  private void addPage(String urlPrefix, List<Canvas> canvases) throws URISyntaxException {
    // add a new page
    Canvas canvas1 = new CanvasImpl(new URI(urlPrefix + "/demo/bookreader/canvas/canvas-1"), "Upper board outside", 2236, 1732);
    canvases.add(canvas1);

    List<Image> images = new ArrayList<>();
    canvas1.setImages(images);

    Image image1 = new ImageImpl("http://dms-data.stanford.edu/data/manifests/Walters/qm670kv1873/imageanno/anno-1");
    image1.setOn(canvas1.getId());
    images.add(image1);

    ImageResource imageResource1 = new ImageResourceImpl(new URI("http://stacks.stanford.edu/image/qm670kv1873/W168_000001_300"));
    imageResource1.setHeight(2236);
    imageResource1.setWidth(1732);
    image1.setResource(imageResource1);

    Service service1 = new ServiceImpl(urlPrefix + "/demo/bookreader/mechanik1/1.jpg?");
    service1.setContext("http://iiif.io/api/image/2/context.json");
    service1.setProfile("http://iiif.io/api/image/2/level1.json");
    imageResource1.setService(service1);
  }

}
