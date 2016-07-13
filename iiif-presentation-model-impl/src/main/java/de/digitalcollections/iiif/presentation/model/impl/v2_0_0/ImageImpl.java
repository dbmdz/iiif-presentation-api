package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Image;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.ImageResource;
import java.net.URI;
import java.net.URISyntaxException;

public class ImageImpl implements Image {

  private URI id;
  private final String motivation = "sc:painting";
  private URI on;

  private ImageResource resource;
  private final String type = "oa:Annotation";

  public ImageImpl() {
  }

  public ImageImpl(URI id) {
    this.id = id;
  }

  public ImageImpl(String id) throws URISyntaxException {
    this.id = new URI(id);
  }

  @Override
  public URI getId() {
    return id;
  }

  @Override
  public String getMotivation() {
    return motivation;
  }

  @Override
  public URI getOn() {
    return on;
  }

  @Override
  public void setOn(URI on) {
    this.on = on;
  }

  @Override
  public ImageResource getResource() {
    return resource;
  }

  @Override
  public void setResource(ImageResource resource) {
    this.resource = resource;
  }

  @Override
  public String getType() {
    return type;
  }

}
