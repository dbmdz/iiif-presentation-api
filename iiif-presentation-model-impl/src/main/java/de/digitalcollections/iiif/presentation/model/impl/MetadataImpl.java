package de.digitalcollections.iiif.presentation.model.impl;

import de.digitalcollections.iiif.presentation.model.api.Metadata;

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
