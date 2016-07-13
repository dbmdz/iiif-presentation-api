package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class MetadataSimpleMixIn {

  @JsonCreator
  public MetadataSimpleMixIn(@JsonProperty("label") String label, @JsonProperty("value") String value) {
  }
}
