package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.AnnotationListImpl;

@JsonDeserialize(as = AnnotationListImpl.class)
public abstract class AnnotationListMixIn extends AbstractIiifResourceMixIn {

}
