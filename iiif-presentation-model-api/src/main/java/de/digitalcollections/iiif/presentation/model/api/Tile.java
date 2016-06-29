package de.digitalcollections.iiif.presentation.model.api;

public interface Tile {

  int[] getScaleFactors();

  void setScaleFactors(int[] scaleFactors);

  int getWidth();

  void setWidth(int width);

}
