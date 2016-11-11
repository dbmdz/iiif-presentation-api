package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.v2.AnnotationListImpl;
import java.net.URI;

@JsonDeserialize(as = AnnotationListImpl.class)
public abstract class AnnotationListMixIn extends AbstractIiifResourceMixIn {

//  @JsonCreator
//  AnnotationListMixIn(@JsonProperty("@id") URI id) {
//  }
  
  @JsonProperty("@context")
  abstract String getContext();
}
