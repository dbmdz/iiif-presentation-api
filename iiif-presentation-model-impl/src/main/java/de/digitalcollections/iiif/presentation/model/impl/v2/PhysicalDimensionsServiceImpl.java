package de.digitalcollections.iiif.presentation.model.impl.v2;

import de.digitalcollections.iiif.presentation.model.api.v2.PhysicalDimensionsService;

public class PhysicalDimensionsServiceImpl extends ServiceImpl implements PhysicalDimensionsService {
  private double physicalScale;
  private String physicalUnits;

  public PhysicalDimensionsServiceImpl() {}

  public PhysicalDimensionsServiceImpl(double physicalScale, String physicalUnits) {
    this.physicalScale = physicalScale;
    this.physicalUnits = physicalUnits;
  }

  @Override
  public String getContext() {
    return "http://iiiif.io/api/annex/services/physdim/1/context.json";
  }

  @Override
  public String getProfile() {
    return "http://iiiif.io/api/annex/services/physdim";
  }

  @Override
  public Double getPhysicalScale() {
    return physicalScale;
  }

  @Override
  public String getPhysicalUnits() {
    return physicalUnits;
  }

  public void setPhysicalScale(double physicalScale) {
    this.physicalScale = physicalScale;
  }

  public void setPhysicalUnits(String physicalUnits) {
    this.physicalUnits = physicalUnits;
  }
}
