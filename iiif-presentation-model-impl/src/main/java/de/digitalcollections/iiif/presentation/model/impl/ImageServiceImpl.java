package de.digitalcollections.iiif.presentation.model.impl;

import de.digitalcollections.iiif.presentation.model.api.ImageService;
import de.digitalcollections.iiif.presentation.model.api.Tile;
import java.util.List;

public class ImageServiceImpl extends ServiceImpl implements ImageService {

  private int height;
  private int width;

  private List<Tile> tiles;

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

  @Override
  public List<Tile> getTiles() {
    return tiles;
  }

  @Override
  public void setTiles(List<Tile> tiles) {
    this.tiles = tiles;
  }

}
