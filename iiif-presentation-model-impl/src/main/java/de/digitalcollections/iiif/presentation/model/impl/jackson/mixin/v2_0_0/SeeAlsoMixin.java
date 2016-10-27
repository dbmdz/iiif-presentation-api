package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.SeeAlso;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.ResourceImpl;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.SeeAlsoImpl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = SeeAlsoImpl.class)
public abstract class SeeAlsoMixin extends AbstractIiifResourceMixIn {
}
