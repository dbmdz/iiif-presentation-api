package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Canvas;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Image;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Metadata;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Thumbnail;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class CanvasImpl extends AbstractIiifResourceImpl implements Canvas {

  private String description; // optional
  private int height; // required
  private List<Image> images;
  private String label; // required
  private List<Metadata> metadata; // optional
  private Thumbnail thumbnail; // recommended
  private String viewingHint; // optional
  private int width; // required

  public CanvasImpl() {
    this.height = 0;
    this.label = null;
    this.width = 0;
  }

  public CanvasImpl(URI id, String label, int height, int width) {
    assert id != null;
    assert label != null;
    assert height > -1;
    assert width > -1;

    this.id = id;
    this.height = height;
    this.label = label;
    this.width = width;

    type = "sc:Canvas";
  }

  public CanvasImpl(String id, String label, int height, int width) throws URISyntaxException {
    this(new URI(id), label, height, width);
  }

  /**
   * @param id A canvas must have an id, and it must be an http(s) URI. The canvas’s JSON representation should be
   * published at that URI.
   * @param label A canvas must have a label, and it should be the page or view label such as “p. 1”, “front”, or “north
   * view”.
   * @param height The height of a canvas or image resource. For images, this is in pixels. No particular units are
   * required for canvases, as the dimensions provide an aspect ratio for the resources to be located within rather than
   * measuring any physical property of the object. A canvas must have a height, which does not have a unit type. It
   * merely conveys, along with width, an aspect ratio.
   * @param width The width of a canvas or image resource. For images, this is in pixels. No particular units are
   * required for canvases. A canvas must have a height, which does not have a unit type. It merely conveys, along with
   * width, an aspect ratio.
   * @param thumbnail A canvas may have a thumbnail and should have a thumbnail if there are multiple images or
   * resources that make up the representation.
   */
  public CanvasImpl(URI id, String label, int height, int width, Thumbnail thumbnail) {
    this(id, label, height, width);
    this.thumbnail = thumbnail;
  }

  public CanvasImpl(String id, String label, int height, int width, Thumbnail thumbnail) throws URISyntaxException {
    this(new URI(id), label, height, width, thumbnail);
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public void setDescription(String description) {
    this.description = description;
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
  public List<Image> getImages() {
    return images;
  }

  @Override
  public void setImages(List<Image> images) {
    this.images = images;
  }

  @Override
  public String getLabel() {
    return label;
  }

  @Override
  public void setLabel(String label) {
    this.label = label;
  }

  @Override
  public List<Metadata> getMetadata() {
    return metadata;
  }

  @Override
  public void setMetadata(List<Metadata> metadata) {
    this.metadata = metadata;
  }

  @Override
  public Thumbnail getThumbnail() {
    return thumbnail;
  }

  @Override
  public void setThumbnail(Thumbnail thumbnail) {
    this.thumbnail = thumbnail;
  }

  @Override
  public String getViewingHint() {
    return viewingHint;
  }

  @Override
  public void setViewingHint(String viewingHint) {
    this.viewingHint = viewingHint;
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
