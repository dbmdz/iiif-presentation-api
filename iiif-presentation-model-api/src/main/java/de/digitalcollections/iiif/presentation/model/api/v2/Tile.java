package de.digitalcollections.iiif.presentation.model.api.v2;

public interface Tile {

  int[] getScaleFactors();

  void setScaleFactors(int[] scaleFactors);

  int getWidth();

  void setWidth(int width);

}
