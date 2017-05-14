package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.v2.PhysicalDimensionsServiceImpl;

@JsonDeserialize(as = PhysicalDimensionsServiceImpl.class)
public abstract class PhysicalDimensionsMixin {
  @JsonProperty("@context")
  abstract String getContext();

  @JsonProperty("@id")
  abstract String getId();

  @JsonProperty("physicalUnits")
  public abstract String getPhysicalUnits();

  @JsonProperty("physicalUnits")
  public abstract void setPhysicalUnits(String units);

  @JsonProperty("physicalScale")
  public abstract double getPhysicalScale();

  @JsonProperty("physicalScale")
  public abstract void setPhysicalScale(double scale);
}
