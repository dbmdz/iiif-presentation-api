package de.digitalcollections.iiif.presentation.model.impl.v2.references;

import de.digitalcollections.iiif.presentation.model.api.v2.PropertyValue;
import de.digitalcollections.iiif.presentation.model.api.v2.references.IiifReference;
import de.digitalcollections.iiif.presentation.model.impl.v2.PropertyValueSimpleImpl;
import java.net.URI;

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
  public void setId(String id) {
    this.id = URI.create(id);
  }

  @Override
  public void setId(URI id) {
    this.id = id;
  }

  @Override
  public PropertyValue getLabel() {
    return label;
  }

  public void setLabel(PropertyValue label) {
    this.label = label;
  }

  @Override
  public abstract String getType();
}
