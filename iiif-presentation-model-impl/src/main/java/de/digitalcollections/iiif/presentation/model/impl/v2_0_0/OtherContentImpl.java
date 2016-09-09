package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.OtherContent;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.PropertyValue;

import java.net.URI;

public class OtherContentImpl extends ContentImpl implements OtherContent {

  private PropertyValue label; // optional

  public OtherContentImpl(URI id) {
    super(id);
    this.type = "oa:Annotation";
  }

  @Override
  public PropertyValue getLabel() {
    return label;
  }

  @Override
  public void setLabel(PropertyValue label) {
    this.label = label;
  }
}
