package de.digitalcollections.iiif.presentation.model.api.enums;

public enum AnnotationMotivation {
  COMMENTING("oa:commenting"), PAINTING("sc:painting");
  
  private final String value;

  private AnnotationMotivation(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
