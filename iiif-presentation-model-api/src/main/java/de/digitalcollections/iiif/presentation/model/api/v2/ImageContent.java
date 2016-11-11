package de.digitalcollections.iiif.presentation.model.api.v2;

/**
 * <p>
 * Recommended URI Pattern: {scheme}://{host}/{prefix}/{identifier}/annotation/{name}
 * </p>
 */
public interface ImageContent extends Content {

  PropertyValue getLabel();

  /**
   * @param label A content resource may have a label, and if there is a choice of content resource for the same canvas,
   * then they must have labels. The label should be a brief description of the resource, such as "black and white"
   * versus "color photograph".
   */
  void setLabel(PropertyValue label);

}
