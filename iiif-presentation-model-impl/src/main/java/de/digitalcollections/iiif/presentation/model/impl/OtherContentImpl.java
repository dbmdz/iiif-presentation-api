package de.digitalcollections.iiif.presentation.model.impl;

import de.digitalcollections.iiif.presentation.model.api.OtherContent;
import java.net.URI;

public class OtherContentImpl extends ContentImpl implements OtherContent {

  private String label; // optional

  public OtherContentImpl(URI id) {
    super(id);
    this.type = "oa:Annotation";
  }

  @Override
  public String getLabel() {
    return label;
  }

  @Override
  public void setLabel(String label) {
    this.label = label;
  }
}
