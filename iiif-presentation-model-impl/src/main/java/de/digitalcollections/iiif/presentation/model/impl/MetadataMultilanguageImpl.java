package de.digitalcollections.iiif.presentation.model.impl;

import java.util.List;

public class MetadataMultilanguageImpl extends MetadataImpl {

  private final List<MetadataLocalizedValueImpl> value;

  public MetadataMultilanguageImpl(String label, List<MetadataLocalizedValueImpl> value) {
    super(label);
    this.value = value;
  }

  public List<MetadataLocalizedValueImpl> getValue() {
    return value;
  }

}
