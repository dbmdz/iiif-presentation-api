package de.digitalcollections.iiif.presentation.model.api.v2_0_0;

import java.util.List;

/**
 * <p>
 * Recommended URI Pattern: {scheme}://{host}/{prefix}/collection/{name}</p>
 */
public interface Collection extends IiifResource {

  String getDescription();

  void setDescription(String description);

  String getLabel();

  List<Metadata> getMetadata();

  Thumbnail getThumbnail();

  void setThumbnail(Thumbnail thumbnail);

  String getViewingHint();

  void setViewingHint(String viewingHint);

}
