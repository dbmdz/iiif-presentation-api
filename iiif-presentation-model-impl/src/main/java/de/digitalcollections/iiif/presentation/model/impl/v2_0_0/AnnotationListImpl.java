package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.AnnotationList;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Metadata;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Thumbnail;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class AnnotationListImpl extends AbstractIiifResourceImpl implements AnnotationList {

  private String description; // optional
  private String label; // optional
  private List<Metadata> metadata; // optional
  private Thumbnail thumbnail; // optional
  private String viewingHint; // optional

  public AnnotationListImpl(URI id) {
    assert id != null;
    this.id = id;

    type = "sc:AnnotationList";
  }

  public AnnotationListImpl(String id) throws URISyntaxException {
    this(new URI(id));
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
}
