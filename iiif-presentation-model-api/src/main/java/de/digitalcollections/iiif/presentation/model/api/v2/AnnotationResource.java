package de.digitalcollections.iiif.presentation.model.api.v2;

import java.net.URI;

public interface AnnotationResource {

  String getFormat();

  URI getId();
  
  void setId(URI id);

  String getType();
}
