package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.v2.ContentImpl;

@JsonDeserialize(as = ContentImpl.class)
public abstract class ContentMixIn extends AbstractIiifResourceMixIn {

}
