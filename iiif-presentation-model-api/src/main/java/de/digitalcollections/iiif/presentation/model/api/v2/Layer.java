package de.digitalcollections.iiif.presentation.model.api.v2;

import de.digitalcollections.iiif.presentation.model.api.enums.ViewingDirection;
import de.digitalcollections.iiif.presentation.model.api.v2.references.IiifReference;
import java.util.List;

/**
 * <p>
 * Recommended URI Pattern: {scheme}://{host}/{prefix}/{identifier}/layer/{name}</p>
 */
public interface Layer extends IiifResource {

  PropertyValue getDescription();

  void setDescription(PropertyValue description);

  PropertyValue getLabel();

  List<Metadata> getMetadata();

  void setMetadata(List<Metadata> metadata);

  List<IiifReference> getOtherContent();

  void setOtherContent(List<IiifReference> iiifReferences);

  Thumbnail getThumbnail();

  void setThumbnail(Thumbnail thumbnail);

  String getViewingDirection();

  /**
   * @param viewingDirection The direction that canvases of the resource should be presented when rendered for the user to navigate and/or read. A range or layer may have a viewing direction.
   * @see ViewingDirection
   */
  void setViewingDirection(String viewingDirection);

  String getViewingHint();

  void setViewingHint(String viewingHint);

}
