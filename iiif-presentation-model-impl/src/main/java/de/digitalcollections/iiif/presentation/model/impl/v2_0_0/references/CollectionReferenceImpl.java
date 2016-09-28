package de.digitalcollections.iiif.presentation.model.impl.v2_0_0.references;

import java.net.URI;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.PropertyValue;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.references.CollectionReference;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.references.IiifReference;

public class CollectionReferenceImpl extends IiifReferenceImpl implements CollectionReference {
  public CollectionReferenceImpl(URI id) {
    super(id);
  }

  public CollectionReferenceImpl(URI id, PropertyValue label) {
    super(id, label);
  }

  @Override
  public String getType() {
    return "sc:Collection";
  }
}
