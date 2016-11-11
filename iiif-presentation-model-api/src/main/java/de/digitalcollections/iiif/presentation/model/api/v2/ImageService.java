package de.digitalcollections.iiif.presentation.model.api.v2;

import java.util.List;

public interface ImageService extends Service {

  int getHeight();

  void setHeight(int height);

  List<Tile> getTiles();

  void setTiles(List<Tile> tiles);

  int getWidth();

  void setWidth(int width);

}
