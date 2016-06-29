package de.digitalcollections.iiif.presentation.model.api;

import java.util.List;

/**
 * <p>
 * Content resources such as images or texts that are associated with a canvas.</p>
 *
 * <ul>
 * <li>A canvas or content resource must not have a viewing direction.</li>
 * </ul>
 */
public interface Content extends IiifResource {

  String getDescription();

  /**
   * @param description A content resource may have a description.
   */
  void setDescription(String description);

  String getFormat();

  /**
   * @param format The specific media type (often called a MIME type) of a content resource, for example “image/jpeg”.
   * This is important for distinguishing text in XML from plain text, for example. A content resource may have a
   * format, and if so, it must be the value of the Content-Type header returned when the resource is dereferenced. N.B.
   * This is different to the formats property in the Image API, which gives the extension to use within that API. It
   * would be inappropriate to use in this case, as format can be used with any content resource, not just images.
   */
  void setFormat(String format);

  int getHeight();

  /**
   * @param height The height of a canvas or image resource. For images, this is in pixels. No particular units are
   * required for canvases, as the dimensions provide an aspect ratio for the resources to be located within rather than
   * measuring any physical property of the object. Content resources may have a height, given in pixels, if
   * appropriate.
   */
  void setHeight(int height);

  List<Metadata> getMetadata();

  /**
   * @param metadata A content resource may have metadata pairs associated with it.
   */
  void setMetadata(List<Metadata> metadata);

  Thumbnail getThumbnail();

  /**
   * @param thumbnail A content resource may have a thumbnail and should have a thumbnail if it is an option in a choice
   * of resources.
   */
  void setThumbnail(Thumbnail thumbnail);

  String getViewingHint();

  /**
   * @param viewingHint A content resource may have a viewing hint but there are no defined values in this
   * specification.
   */
  void setViewingHint(String viewingHint);

  int getWidth();

  /**
   * @param width The width of a canvas or image resource. For images, this is in pixels. No particular units are
   * required for canvases. Content resources may have a height, given in pixels, if appropriate.
   */
  void setWidth(int width);

}
