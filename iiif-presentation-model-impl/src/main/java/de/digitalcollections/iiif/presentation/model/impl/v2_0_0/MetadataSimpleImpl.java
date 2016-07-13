package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

public class MetadataSimpleImpl extends MetadataImpl {

  private final String value;

  public MetadataSimpleImpl(String label, String value) {
    super(label);
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
