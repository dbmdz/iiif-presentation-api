package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.v2.SeeAlsoImpl;

@JsonDeserialize(as = SeeAlsoImpl.class)
public abstract class SeeAlsoMixin extends AbstractIiifResourceMixIn {
  @JsonProperty("label")
  public abstract String getLabel();

  @JsonProperty("label")
  public abstract void setLabel(String label);
}
