package de.digitalcollections.iiif.presentation.model.api.enums;

/**
 * A hint to the client as to the most appropriate method of displaying the resource. Other values may be given, and if
 * they are, they must be URIs.
 */
public enum ViewingHint {
  /**
   * Valid on manifest, sequence and range. Each canvas is the complete view of one side of a long scroll or roll and an
   * appropriate rendering might only display part of the canvas at any given time rather than the entire object.
   */
  CONTINUOUS("continuous"),
  /**
   * Valid on manifest, sequence and range. The canvases referenced from the resource are all individual sheets, and
   * should not be presented in a page-turning interface. Examples include a set of views of a 3 dimensional object, or
   * a set of the front sides of photographs in a collection.
   */
  INDIVIDUALS("individuals"),
  /**
   * Canvases with this hint must not be presented in a page turning interface, and must be skipped over when
   * determining the page sequence. This viewing hint must be ignored if the current sequence or manifest does not have
   * the ‘paged’ viewing hint.
   */
  NON_PAGED("non-paged"),
  /**
   * Valid on manifest, sequence and range. The canvases represent pages in a bound volume, and should be presented in a
   * page-turning interface if one is available. The first canvas is a single view (the first recto) and thus the second
   * canvas represents the back of the object in the first canvas.
   */
  PAGED("paged"),
  /**
   * Only valid on a range. A range which has this viewingHint is the top-most node in a hierarchy of ranges that
   * represents a structure to be rendered by the client to assist in navigation. For example, a table of contents
   * within a paged object, major sections of a 3d object, the textual areas within a single scroll, and so forth. Other
   * ranges that are descendants of the “top” range are the entries to be rendered in the navigation structure. There
   * may be multiple ranges marked with this hint. If so, the client should display a choice of multiple structures to
   * navigate through.
   */
  TOP("top");

  private final String value;

  private ViewingHint(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
