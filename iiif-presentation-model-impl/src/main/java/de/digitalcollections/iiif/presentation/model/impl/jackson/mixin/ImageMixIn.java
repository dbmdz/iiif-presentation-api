package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.ImageImpl;

@JsonDeserialize(as = ImageImpl.class)
public abstract class ImageMixIn extends AbstractIiifResourceMixIn {

}
