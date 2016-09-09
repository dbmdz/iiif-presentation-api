package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.PropertyValue;

public class PropertyValueSimpleImpl implements PropertyValue {
  private String value;

  public PropertyValueSimpleImpl(String value) {
    this.value = value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String getValue() {
    return value;
  }
}
