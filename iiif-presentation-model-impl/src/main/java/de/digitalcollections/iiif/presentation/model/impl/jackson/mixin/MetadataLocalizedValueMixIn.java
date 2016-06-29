package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class MetadataLocalizedValueMixIn {

  @JsonProperty("@language")
  abstract String getLanguage();

  @JsonProperty("@value")
  abstract String getValue();

  @JsonCreator
  public MetadataLocalizedValueMixIn(@JsonProperty("@value") String value, @JsonProperty("@language") String language) {
  }
}
