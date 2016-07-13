package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.ThumbnailImpl;

@JsonDeserialize(as = ThumbnailImpl.class)
public abstract class ThumbnailMixIn {

  @JsonProperty("@id")
  abstract String getId();
}
