package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.v2.ServiceImpl;

@JsonDeserialize(as = ServiceImpl.class)
public abstract class ServiceMixIn {

  @JsonProperty("@context")
  abstract String getContext();

  @JsonProperty("@id")
  abstract String getId();

  @JsonIgnore
  abstract void setId(String id);
}
