package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract
class PropertyValueLocalizedMixin {
  @JsonCreator
  public PropertyValueLocalizedMixin(@JsonProperty("@language") String language, @JsonProperty("@value") String value) {
  }
}
