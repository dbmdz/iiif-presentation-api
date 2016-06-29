package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.CanvasImpl;
import java.net.URI;

@JsonDeserialize(as = CanvasImpl.class)
public abstract class CanvasMixIn extends AbstractIiifResourceMixIn {

  @JsonCreator
  CanvasMixIn(@JsonProperty("@id") URI id, @JsonProperty("label") String label, @JsonProperty("height") int height, @JsonProperty(
          "width") int width) {
  }
}
