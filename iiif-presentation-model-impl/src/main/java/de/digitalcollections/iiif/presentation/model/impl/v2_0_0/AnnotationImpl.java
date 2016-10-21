package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Annotation;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.AnnotationResource;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Metadata;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.PropertyValue;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Thumbnail;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class AnnotationImpl extends AbstractIiifResourceImpl implements Annotation {

  private PropertyValue description; // optional
  private PropertyValue label; // optional
  private List<Metadata> metadata; // optional
  private String motivation; // required
  private URI on;

  private AnnotationResource resource;

  private Thumbnail thumbnail; // optional
  private String viewingHint; // optional

  public AnnotationImpl() {

  }

  public AnnotationImpl(String motivation) {
    type = "oa:Annotation";
    this.motivation = motivation;
  }

  /**
   * Convenience constructor (as id and label are optional)
   *
   * @param motivation motivation of this annotation
   * @param id unique id of resource
   * @param label label of the Annotation
   */
  public AnnotationImpl(String motivation, URI id, PropertyValue label) {
    this(motivation);
    this.label = label;
    this.id = id;
  }

  public AnnotationImpl(String motivation, String id, PropertyValue label) throws URISyntaxException {
    this(motivation, new URI(id), label);
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
  public URI getOn() {
    return on;
  }

  @Override
  public void setOn(URI on) {
    this.on = on;
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
  public String getMotivation() {
    return motivation;
  }

  @Override
  public AnnotationResource getResource() {
    return resource;
  }

  @Override
  public void setResource(AnnotationResource annotationResource) {
    this.resource = annotationResource;
  }
}
