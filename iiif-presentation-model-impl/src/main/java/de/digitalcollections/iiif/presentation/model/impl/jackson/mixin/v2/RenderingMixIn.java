package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.v2.RenderingImpl;

@JsonDeserialize(as = RenderingImpl.class)
public abstract class RenderingMixIn {
    @JsonProperty("@id")
    abstract String getId();
}
