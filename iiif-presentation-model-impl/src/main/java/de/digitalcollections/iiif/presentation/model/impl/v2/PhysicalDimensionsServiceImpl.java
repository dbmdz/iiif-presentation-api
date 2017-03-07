package de.digitalcollections.iiif.presentation.model.impl.v2;

public class PhysicalDimensionsServiceImpl extends ServiceImpl {
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

  public Double getPhysicalScale() {
    return physicalScale;
  }

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
