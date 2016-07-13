package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.CollectionImpl;

@JsonDeserialize(as = CollectionImpl.class)
public abstract class CollectionMixIn extends AbstractIiifResourceMixIn {

}
