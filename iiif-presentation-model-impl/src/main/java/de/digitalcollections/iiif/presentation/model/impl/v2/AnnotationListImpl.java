package de.digitalcollections.iiif.presentation.model.impl.v2;

import de.digitalcollections.iiif.presentation.model.api.v2.Annotation;
import de.digitalcollections.iiif.presentation.model.api.v2.AnnotationList;
import de.digitalcollections.iiif.presentation.model.api.v2.Metadata;
import de.digitalcollections.iiif.presentation.model.api.v2.PropertyValue;
import de.digitalcollections.iiif.presentation.model.api.v2.Thumbnail;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class AnnotationListImpl extends AbstractIiifResourceImpl implements AnnotationList {

  private final String context = "http://iiif.io/api/presentation/2/context.json";
  private PropertyValue description; // optional
  private PropertyValue label; // optional
  private List<Metadata> metadata; // optional
  private List<Annotation> resources;
  private Thumbnail thumbnail; // optional
  private String viewingHint; // optional

  public AnnotationListImpl() {
    
  }
  
  public AnnotationListImpl(URI id) {
    assert id != null;
    this.id = id;

    type = "sc:AnnotationList";
  }

  public AnnotationListImpl(String id) throws URISyntaxException {
    this(new URI(id));
  }

  @Override
  public String getContext() {
    return context;
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
  public List<Annotation> getResources() {
    return resources;
  }

  @Override
  public void setResources(List<Annotation> resources) {
    this.resources = resources;
  }
}
