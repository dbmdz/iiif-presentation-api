package com.datazuul.iiif.presentation.api.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Ralf Eichinger (ralf.eichinger at bsb-muenchen.de)
 */
public abstract class MetadataSimpleMixIn {

  @JsonCreator
  public MetadataSimpleMixIn(@JsonProperty("label") String label, @JsonProperty("value") String value) {
  }
}
