package de.digitalcollections.iiif.presentation.model.api.enums;

/**
 * The direction that canvases of the resource should be presented when rendered for the user to navigate and/or read.
 * Possible values are:
 */
public enum ViewingDirection {

  /**
   * The object is read from left to right, and is the default if not specified.
   */
  LTR("left-to-right"),
  /**
   * The object is read from right to left.
   */
  RTL("right-to-left"),
  /**
   * The object is read from the top to the bottom.
   */
  TTB("top-to-bottom"),
  /**
   * The object is read from the bottom to the top.
   */
  BTT("bottom-to-top");

  private final String value;

  private ViewingDirection(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
