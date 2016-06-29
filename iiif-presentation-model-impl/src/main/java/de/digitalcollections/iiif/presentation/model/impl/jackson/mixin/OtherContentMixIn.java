package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.OtherContentImpl;

@JsonDeserialize(as = OtherContentImpl.class)
public abstract class OtherContentMixIn extends ContentMixIn {

}
