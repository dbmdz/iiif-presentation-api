package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import java.util.Arrays;
import java.util.List;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.PropertyValue;

public class PropertyValueSimpleImpl implements PropertyValue {
  private List<String> values;

  public PropertyValueSimpleImpl(String value) {
    this(Arrays.asList(value));
  }

  public PropertyValueSimpleImpl(List<String> values) {
    this.values = values;
  }

  public void setValue(String value) {
    this.values = Arrays.asList(value);
  }

  @Override
  public List<String> getValues() {
    return values;
  }
}
