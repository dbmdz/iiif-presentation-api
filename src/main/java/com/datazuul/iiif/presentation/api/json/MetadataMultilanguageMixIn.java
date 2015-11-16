package com.datazuul.iiif.presentation.api.json;

import com.datazuul.iiif.presentation.api.model.other.MetadataLocalizedValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author Ralf Eichinger (ralf.eichinger at bsb-muenchen.de)
 */
public class MetadataMultilanguageMixIn {

  @JsonCreator
  public MetadataMultilanguageMixIn(@JsonProperty("label") String label, @JsonProperty("value") List<MetadataLocalizedValue> value) {
  }
}
