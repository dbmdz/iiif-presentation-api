package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Metadata;

public abstract class MetadataImpl implements Metadata {

  private final String label;

  public MetadataImpl(String label) {
    this.label = label;
  }

  @Override
  public String getLabel() {
    return label;
  }
}
