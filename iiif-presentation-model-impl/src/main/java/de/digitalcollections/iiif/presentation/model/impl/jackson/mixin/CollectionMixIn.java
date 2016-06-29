package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.CollectionImpl;

@JsonDeserialize(as = CollectionImpl.class)
public abstract class CollectionMixIn extends AbstractIiifResourceMixIn {

}
