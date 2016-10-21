package de.digitalcollections.iiif.presentation.model.api.v2_0_0;

import java.net.URI;
import java.util.List;

/**
 * <p>
 * Recommended URI Pattern: {scheme}://{host}/{prefix}/{identifier}/annotation/{name}</p>
 */
public interface Annotation extends IiifResource {

  PropertyValue getDescription();

  void setDescription(PropertyValue description);

  PropertyValue getLabel();

  void setLabel(PropertyValue label);

  List<Metadata> getMetadata();

  void setMetadata(List<Metadata> metadata);

  String getMotivation();

  URI getOn();

  void setOn(URI on);

  AnnotationResource getResource();
  
  void setResource(AnnotationResource annotationResource);
  
  Thumbnail getThumbnail();

  void setThumbnail(Thumbnail thumbnail);

  String getViewingHint();

  void setViewingHint(String viewingHint);

}
