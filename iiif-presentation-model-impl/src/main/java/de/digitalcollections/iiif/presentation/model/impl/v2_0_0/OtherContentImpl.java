package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.OtherContent;
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
