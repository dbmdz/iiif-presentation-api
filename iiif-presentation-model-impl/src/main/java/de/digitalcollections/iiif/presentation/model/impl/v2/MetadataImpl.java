package de.digitalcollections.iiif.presentation.model.impl.v2;

import de.digitalcollections.iiif.presentation.model.api.v2.Metadata;
import de.digitalcollections.iiif.presentation.model.api.v2.PropertyValue;

public class MetadataImpl implements Metadata {
  private PropertyValue label;
  private PropertyValue value;

  public MetadataImpl() {
  }

  public void setLabel(PropertyValue label) {
    this.label = label;
  }

  public void setValue(PropertyValue value) {
    this.value = value;
  }

  public MetadataImpl(PropertyValue label, PropertyValue value) {
    this.label = label;
    this.value = value;
  }

  @Override
  public PropertyValue getLabel() {
    return label;
  }

  @Override
  public PropertyValue getValue() {
    return value;
  }
}
