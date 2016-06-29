package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.digitalcollections.iiif.presentation.model.impl.MetadataLocalizedValueImpl;
import java.util.List;

public abstract class MetadataMultilanguageMixIn {

  @JsonCreator
  public MetadataMultilanguageMixIn(@JsonProperty("label") String label, @JsonProperty("value") List<MetadataLocalizedValueImpl> value) {
  }
}
