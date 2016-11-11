package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.v2.ImageImpl;

@JsonDeserialize(as = ImageImpl.class)
public abstract class ImageMixIn extends AbstractIiifResourceMixIn {

}
