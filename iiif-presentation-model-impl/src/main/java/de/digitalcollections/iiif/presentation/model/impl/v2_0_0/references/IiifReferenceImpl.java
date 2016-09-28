package de.digitalcollections.iiif.presentation.model.impl.v2_0_0.references;

import java.net.URI;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.PropertyValue;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.references.IiifReference;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.PropertyValueSimpleImpl;

public abstract class IiifReferenceImpl implements IiifReference {
  private URI id;
  private PropertyValue label;

  public IiifReferenceImpl(URI id) {
    this.id = id;
    this.label = new PropertyValueSimpleImpl("");
  }

  public IiifReferenceImpl(URI id, PropertyValue label) {
    this.id = id;
    this.label = label;
  }

  @Override
  public URI getId() {
    return id;
  }

  @Override
  public abstract String getType();

  @Override
  public PropertyValue getLabel() {
    return label;
  }
}
