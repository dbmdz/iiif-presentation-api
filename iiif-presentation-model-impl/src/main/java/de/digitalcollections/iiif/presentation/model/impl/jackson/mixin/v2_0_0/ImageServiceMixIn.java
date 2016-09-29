package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.ImageServiceImpl;

@JsonDeserialize(as = ImageServiceImpl.class)
public abstract class ImageServiceMixIn extends ServiceMixIn {

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  abstract int getHeight();

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  abstract int getWidth();
}
