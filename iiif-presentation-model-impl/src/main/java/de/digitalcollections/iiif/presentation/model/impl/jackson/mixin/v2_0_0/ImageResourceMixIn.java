package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.ImageResourceImpl;

@JsonDeserialize(as = ImageResourceImpl.class)
public abstract class ImageResourceMixIn extends ResourceMixIn {

}
