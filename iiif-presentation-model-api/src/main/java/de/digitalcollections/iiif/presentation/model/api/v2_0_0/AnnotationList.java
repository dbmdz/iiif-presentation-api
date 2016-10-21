package de.digitalcollections.iiif.presentation.model.api.v2_0_0;

import java.util.List;

/**
 * <p>
 * Recommended URI Pattern: {scheme}://{host}/{prefix}/{identifier}/list/{name}</p>
 */
public interface AnnotationList extends IiifResource {
  
  String getContext();

  PropertyValue getDescription();

  void setDescription(PropertyValue description);

  PropertyValue getLabel();

  void setLabel(PropertyValue label);

  List<Metadata> getMetadata();

  void setMetadata(List<Metadata> metadata);

  List<Annotation> getResources();
  
  void setResources(List<Annotation> resources);
  
  Thumbnail getThumbnail();

  void setThumbnail(Thumbnail thumbnail);

  String getViewingHint();

  void setViewingHint(String viewingHint);

}
