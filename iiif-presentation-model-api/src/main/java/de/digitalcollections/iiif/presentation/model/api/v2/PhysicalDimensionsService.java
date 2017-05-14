package de.digitalcollections.iiif.presentation.model.api.v2;

public interface PhysicalDimensionsService extends Service {
  Double getPhysicalScale();

  String getPhysicalUnits();
}
