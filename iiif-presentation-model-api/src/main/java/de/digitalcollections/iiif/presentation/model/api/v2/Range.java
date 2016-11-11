package de.digitalcollections.iiif.presentation.model.api.v2;

import de.digitalcollections.iiif.presentation.model.api.enums.ViewingDirection;

import java.util.List;

/**
 * <p>
 * Recommended URI Pattern: {scheme}://{host}/{prefix}/{identifier}/range/{name}
 */
public interface Range extends IiifResource {

  List<String> getCanvases();

  void setCanvases(List<String> canvases);

  PropertyValue getDescription();

  void setDescription(PropertyValue description);

  PropertyValue getLabel();

  void setLabel(PropertyValue label);

  List<Metadata> getMetadata();

  void setMetadata(List<Metadata> metadata);

  List<String> getRanges();

  void setRanges(List<String> ranges);

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

  void setThumbnail(Thumbnail thumbnail);

  String getViewingDirection();

  /**
   * @param viewingDirection The direction that canvases of the resource should be presented when rendered for the user
   * to navigate and/or read. A range or layer may have a viewing direction.
   * @see ViewingDirection
   */
  void setViewingDirection(String viewingDirection);

  String getViewingHint();

  void setViewingHint(String viewingHint);

}
