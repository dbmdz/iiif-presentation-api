package de.digitalcollections.iiif.presentation.model.api.v2_0_0;

import java.net.URI;

public interface AnnotationResource {

  String getFormat();

  URI getId();
  
  void setId(URI id);

  String getType();
}
