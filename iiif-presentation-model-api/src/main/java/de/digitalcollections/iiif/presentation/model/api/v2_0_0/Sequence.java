package de.digitalcollections.iiif.presentation.model.api.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.enums.ViewingDirection;
import de.digitalcollections.iiif.presentation.model.api.enums.ViewingHint;
import java.net.URI;
import java.util.List;

/**
 * <p>
 * Recommended URI Pattern: {scheme}://{host}/{prefix}/{identifier}/sequence/{name}
 *
 * <ul>
 * <li>Each sequence must have at least one canvas and is likely to have more than one.</li>
 * <li>A manifest, sequence or canvas must not have a format.</li>
 * <li>A manifest or sequence must not have a height.</li>
 * <li>A manifest or sequence must not have a width.</li>
 * </ul>
 */
public interface Sequence extends IiifResource {

  List<Canvas> getCanvases();

  void setCanvases(List<Canvas> canvases);

  String getDescription();

  /**
   * @param description A sequence may have a description to further explain how it differs from other sequences.
   */
  void setDescription(String description);

  /**
   * @param id A sequence may have an id.
   */
  @Override
  void setId(URI id);

  PropertyValue getLabel();

  void setLabel(PropertyValue label);

  List<Metadata> getMetadata();

  /**
   * @param metadata A sequence may have metadata pairs associated with it to describe the difference between it and
   * other sequences.
   */
  void setMetadata(List<Metadata> metadata);

  String getStartCanvas();

  /**
   * @param startCanvas A link from a sequence or range to a canvas that is contained within the sequence. On seeing
   * this relationship, a client should advance to the specified canvas when beginning navigation through the
   * sequence/range. This allows the client to begin with the first canvas that contains interesting content rather than
   * requiring the user to skip past blank or empty canvases manually. A sequence or a range may have this relationship,
   * and the target must be a canvas.
   */
  void setStartCanvas(String startCanvas);

  Thumbnail getThumbnail();

  /**
   * @param thumbnail A sequence may have a thumbnail and should have a thumbnail if there are multiple sequences in a
   * single manifest. Each of the thumbnails should be different.
   */
  void setThumbnail(Thumbnail thumbnail);

  String getViewingDirection();

  /**
   * @param viewingDirection The direction that canvases of the resource should be presented when rendered for the user
   * to navigate and/or read. A sequence may have a viewing direction, and it MAY be different to that of the manifest.
   * @see ViewingDirection
   */
  void setViewingDirection(String viewingDirection);

  String getViewingHint();

  /**
   * @param viewingHint A manifest, sequence or range may have a viewing hint, with scope as per viewingDirection.
   * @see ViewingHint
   */
  void setViewingHint(String viewingHint);

}
