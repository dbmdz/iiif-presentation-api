package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.v2.CollectionImpl;

@JsonDeserialize(as = CollectionImpl.class)
public abstract class CollectionMixIn extends AbstractIiifResourceMixIn {

  @JsonProperty("@context")
  abstract String getContext();

  @JsonProperty("collections")
  abstract String getSubCollections();

}
