package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractIiifResourceMixIn {

  @JsonProperty("@id")
  abstract String getId();

  @JsonProperty("@type")
  abstract String getType();

  @JsonIgnore
  abstract void setId(String id);
}
