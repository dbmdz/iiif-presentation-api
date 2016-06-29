package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.ResourceImpl;

@JsonDeserialize(as = ResourceImpl.class)
public abstract class ResourceMixIn extends AbstractIiifResourceMixIn {

}
