package de.digitalcollections.iiif.presentation.model.impl.v2;

import de.digitalcollections.iiif.presentation.model.api.v2.ImageResource;
import java.net.URI;

public class ImageResourceImpl extends ResourceImpl implements ImageResource {

  private int height;
  private int width;

  public ImageResourceImpl() {
    type = "dctypes:Image";
  }

  public ImageResourceImpl(URI id) {
    this();
    this.id = id;
  }

  public ImageResourceImpl(String id) {
    this(URI.create(id));
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public void setWidth(int width) {
    this.width = width;
  }
}
