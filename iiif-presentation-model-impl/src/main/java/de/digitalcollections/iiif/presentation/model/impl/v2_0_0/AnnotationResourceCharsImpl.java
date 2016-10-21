package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.AnnotationResourceChars;

public class AnnotationResourceCharsImpl extends AnnotationResourceImpl implements AnnotationResourceChars {

  private String chars;

  public AnnotationResourceCharsImpl(String type, String format) {
    super(type, format);
  }

  @Override
  public String getChars() {
    return chars;
  }

  @Override
  public void setChars(String chars) {
    this.chars = chars;
  }
}
