package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.ImageContentImpl;

@JsonDeserialize(as = ImageContentImpl.class)
public abstract class ImageContentMixIn extends ContentMixIn {

}
