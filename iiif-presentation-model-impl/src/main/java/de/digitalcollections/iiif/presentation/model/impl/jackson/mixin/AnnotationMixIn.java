package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.AnnotationImpl;

@JsonDeserialize(as = AnnotationImpl.class)
public abstract class AnnotationMixIn extends AbstractIiifResourceMixIn {

}
