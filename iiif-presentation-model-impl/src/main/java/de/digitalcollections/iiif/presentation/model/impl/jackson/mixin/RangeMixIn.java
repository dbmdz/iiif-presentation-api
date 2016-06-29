package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.RangeImpl;

@JsonDeserialize(as = RangeImpl.class)
public abstract class RangeMixIn extends AbstractIiifResourceMixIn {

}
