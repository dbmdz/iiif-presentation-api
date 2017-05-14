package de.digitalcollections.iiif.presentation.model.impl.v2.references;

import de.digitalcollections.iiif.presentation.model.api.v2.PropertyValue;
import de.digitalcollections.iiif.presentation.model.api.v2.references.CollectionReference;
import java.net.URI;

public class CollectionReferenceImpl extends IiifReferenceImpl implements CollectionReference {

  private String type = "sc:Collection";

  public CollectionReferenceImpl() {
    this(null);
  }

  public CollectionReferenceImpl(URI id) {
    super(id);
  }

  public CollectionReferenceImpl(URI id, PropertyValue label) {
    super(id, label);
  }

  @Override
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
