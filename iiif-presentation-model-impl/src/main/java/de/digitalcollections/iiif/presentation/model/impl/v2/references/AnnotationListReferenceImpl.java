package de.digitalcollections.iiif.presentation.model.impl.v2.references;

import de.digitalcollections.iiif.presentation.model.api.v2.references.AnnotationListReference;
import java.net.URI;

public class AnnotationListReferenceImpl extends IiifReferenceImpl implements AnnotationListReference {

  public AnnotationListReferenceImpl(URI id) {
    super(id);
  }

  @Override
  public String getType() {
    return "sc:AnnotationList";
  }
}
