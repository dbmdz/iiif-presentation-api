package de.digitalcollections.iiif.presentation.model.impl.v2;

import de.digitalcollections.iiif.presentation.model.api.v2.ImageContent;
import de.digitalcollections.iiif.presentation.model.api.v2.PropertyValue;

import java.net.URI;

public class ImageContentImpl extends ContentImpl implements ImageContent {

  private PropertyValue label; // optional

  public ImageContentImpl(URI id) {
    super(id);
    this.type = "oa:Annotation"; // required
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
