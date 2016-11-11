package de.digitalcollections.iiif.presentation.model.impl.v2;

import de.digitalcollections.iiif.presentation.model.api.v2.OtherContent;
import de.digitalcollections.iiif.presentation.model.api.v2.PropertyValue;

import java.net.URI;

public class OtherContentImpl extends ContentImpl implements OtherContent {

  private PropertyValue label; // optional

  public OtherContentImpl(URI id, String type) {
    super(id);
//    this.type = "oa:Annotation";
    this.type = type;
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
