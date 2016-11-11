package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.v2.AnnotationImpl;

@JsonDeserialize(as = AnnotationImpl.class)
public abstract class AnnotationMixIn extends AbstractIiifResourceMixIn {

  @JsonCreator
  AnnotationMixIn(@JsonProperty("motivation") String motivation) {
  }
}
