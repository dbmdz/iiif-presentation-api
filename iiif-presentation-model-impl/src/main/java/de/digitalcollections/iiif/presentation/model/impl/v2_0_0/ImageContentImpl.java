package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.ImageContent;
import java.net.URI;

public class ImageContentImpl extends ContentImpl implements ImageContent {

  private String label; // optional

  public ImageContentImpl(URI id) {
    super(id);
    this.type = "oa:Annotation"; // required
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
