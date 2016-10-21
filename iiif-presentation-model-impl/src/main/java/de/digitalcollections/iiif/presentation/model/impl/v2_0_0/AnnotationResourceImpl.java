package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.AnnotationResource;
import java.net.URI;

public class AnnotationResourceImpl implements AnnotationResource {

  private String format;
  private URI id;
  private String type;

  public AnnotationResourceImpl() {
  }

  public AnnotationResourceImpl(String type, String format) {
    this.format = format;
    this.type = type;
  }

  @Override
  public String getFormat() {
    return format;
  }

  @Override
  public URI getId() {
    return id;
  }

  @Override
  public void setId(URI id) {
    this.id = id;
  }

  @Override
  public String getType() {
    return type;
  }
}
