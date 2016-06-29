package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.ThumbnailImpl;

@JsonDeserialize(as = ThumbnailImpl.class)
public abstract class ThumbnailMixIn {

  @JsonProperty("@id")
  abstract String getId();
}
