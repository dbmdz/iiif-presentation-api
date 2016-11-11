package de.digitalcollections.iiif.presentation.model.api.v2;

public interface ImageResource extends Resource {

  int getHeight();

  void setHeight(int height);

  int getWidth();

  void setWidth(int width);

}
