package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.ImageServiceImpl;

@JsonDeserialize(as = ImageServiceImpl.class)
public abstract class ImageServiceMixIn extends ServiceMixIn {

}
