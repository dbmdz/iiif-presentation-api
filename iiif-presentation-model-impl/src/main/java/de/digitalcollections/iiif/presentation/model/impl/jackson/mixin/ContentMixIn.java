package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.ContentImpl;

@JsonDeserialize(as = ContentImpl.class)
public abstract class ContentMixIn extends AbstractIiifResourceMixIn {

}
