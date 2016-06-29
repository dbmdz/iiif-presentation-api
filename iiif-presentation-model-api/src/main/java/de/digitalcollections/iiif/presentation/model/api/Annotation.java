package de.digitalcollections.iiif.presentation.model.api;

import java.util.List;

/**
 * <p>
 * Recommended URI Pattern: {scheme}://{host}/{prefix}/{identifier}/annotation/{name}</p>
 */
public interface Annotation extends IiifResource {

  String getDescription();

  void setDescription(String description);

  String getLabel();

  void setLabel(String label);

  List<Metadata> getMetadata();

  void setMetadata(List<Metadata> metadata);

  Thumbnail getThumbnail();

  void setThumbnail(Thumbnail thumbnail);

  String getViewingHint();

  void setViewingHint(String viewingHint);

}
