package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Layer;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Metadata;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.PropertyValue;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Thumbnail;
import java.net.URI;
import java.util.List;

public class LayerImpl extends AbstractIiifResourceImpl implements Layer {

  private PropertyValue description; // optional
  private final PropertyValue label; // required
  private List<Metadata> metadata; // optional
  private Thumbnail thumbnail; // optional
  private String viewingDirection; // optional
  private String viewingHint; // optional

  public LayerImpl(URI id, PropertyValue label) {
    assert id != null;
    assert label != null;

    this.id = id;
    this.label = label;

    type = "sc:Layer";
  }

  @Override
  public PropertyValue getDescription() {
    return description;
  }

  @Override
  public void setDescription(PropertyValue description) {
    this.description = description;
  }

  @Override
  public PropertyValue getLabel() {
    return label;
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
