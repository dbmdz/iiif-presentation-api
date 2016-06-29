package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.LayerImpl;

@JsonDeserialize(as = LayerImpl.class)
public abstract class LayerMixIn extends AbstractIiifResourceMixIn {

}
