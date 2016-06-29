package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.ManifestImpl;

@JsonDeserialize(as = ManifestImpl.class)
public abstract class ManifestMixIn extends AbstractIiifResourceMixIn {

  @JsonProperty("@context")
  abstract String getContext();
}
