package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.ImageResourceImpl;

@JsonDeserialize(as = ImageResourceImpl.class)
public abstract class ImageResourceMixIn extends ResourceMixIn {

}
