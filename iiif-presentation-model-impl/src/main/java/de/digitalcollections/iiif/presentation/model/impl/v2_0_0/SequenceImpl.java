package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.*;

import java.net.URI;
import java.util.List;

public class SequenceImpl extends AbstractIiifResourceImpl implements Sequence {

  private List<Canvas> canvases;
  private String description; // optional
  private PropertyValue label; // optional
  private List<Metadata> metadata; // optional
  private String startCanvas; // optional
  private Thumbnail thumbnail; // optional
  private String viewingDirection; // optional
  private String viewingHint; // optional

  public SequenceImpl() {
    type = "sc:Sequence";
  }

  /**
   * @param label A sequence may have a label, and if there are multiple sequences in a single manifest then they must
   * have labels. The label should briefly convey the nature of sequence, such as “Current Page Order”.
   */
  public SequenceImpl(PropertyValue label) {
    this();
    assert label != null;
    this.label = label;
  }

  /**
   * Convenience constructor (as id is optional)
   *
   * @param id unique id of resource
   * @param label The label should briefly convey the nature of sequence, such as “Current Page Order”.
   */
  public SequenceImpl(URI id, PropertyValue label) {
    this(label);
    this.id = id;
  }

  @Override
  public List<Canvas> getCanvases() {
    return canvases;
  }

  @Override
  public void setCanvases(List<Canvas> canvases) {
    this.canvases = canvases;
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
  public void setId(URI id) {
    this.id = id;
  }

  @Override
  public PropertyValue getLabel() {
    return label;
  }

  @Override
  public void setLabel(PropertyValue label) {
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
  public String getStartCanvas() {
    return startCanvas;
  }

  @Override
  public void setStartCanvas(String startCanvas) {
    this.startCanvas = startCanvas;
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
  public String getViewingDirection() {
    return viewingDirection;
  }

  @Override
  public void setViewingDirection(String viewingDirection) {
    this.viewingDirection = viewingDirection;
  }

  @Override
  public String getViewingHint() {
    return viewingHint;
  }

  @Override
  public void setViewingHint(String viewingHint) {
    this.viewingHint = viewingHint;
  }
}
