package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.ManifestImpl;

@JsonDeserialize(as = ManifestImpl.class)
public abstract class ManifestMixIn extends AbstractIiifResourceMixIn {

  @JsonProperty("@context")
  abstract String getContext();
}
