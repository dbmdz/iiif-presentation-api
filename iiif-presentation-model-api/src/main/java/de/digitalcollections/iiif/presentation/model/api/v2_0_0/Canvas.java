package de.digitalcollections.iiif.presentation.model.api.v2_0_0;

import java.util.List;

/**
 * <p>
 * The canvas represents an individual page or view and acts as a central point for laying out the different content
 * resources that make up the display. As with sequences, the name should not begin with a number. Suggested patterns
 * are “f1r” or “p1”.</p>
 *
 * <p>
 * Recommended URI Pattern: {scheme}://{host}/{prefix}/{identifier}/canvas/{name}</p>
 *
 * <ul>
 * <li>Each canvas should have one or more content resources associated with it. Zero is possible but unlikely; it
 * represents the case where the page exists (or existed) but has not been digitized.</li>
 * <li>A manifest, sequence or canvas must not have a format.</li>
 * <li>A canvas or content resource must not have a viewing direction.</li>
 * </ul>
 */
public interface Canvas extends IiifResource {

  String getDescription();

  /**
   * @param description A canvas may have a description to describe particular features of the view.
   */
  void setDescription(String description);

  int getHeight();

  void setHeight(int height);

  List<Image> getImages();

  void setImages(List<Image> images);

  String getLabel();

  void setLabel(String label);

  List<Metadata> getMetadata();

  /**
   * @param metadata A canvas may have metadata pairs associated with it to describe its particular features.
   */
  void setMetadata(List<Metadata> metadata);

  Thumbnail getThumbnail();

  /**
   * @param thumbnail A canvas may have a thumbnail and should have a thumbnail if there are multiple images or
   * resources that make up the representation.
   */
  void setThumbnail(Thumbnail thumbnail);

  String getViewingHint();

  /**
   * @param viewingHint A manifest, sequence or range may have a viewing hint, with scope as per viewingDirection. A
   * canvas may have a viewing hint, and the only hint defined by this specification for canvases is "non-paged".
   * "non-paged" is only valid if the canvas is within a manifest, sequence or range that is "paged", and the particular
   * canvas must not be displayed in a page-turning viewer.
   */
  void setViewingHint(String viewingHint);

  int getWidth();

  void setWidth(int width);

}
