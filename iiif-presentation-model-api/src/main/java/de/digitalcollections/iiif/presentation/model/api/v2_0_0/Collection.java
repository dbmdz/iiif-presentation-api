package de.digitalcollections.iiif.presentation.model.api.v2_0_0;

import java.util.List;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.references.CollectionReference;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.references.ManifestReference;

/**
 * <p>
 * Recommended URI Pattern: {scheme}://{host}/{prefix}/collection/{name}</p>
 */
public interface Collection extends IiifResource {

  PropertyValue getDescription();

  void setDescription(PropertyValue description);

  PropertyValue getLabel();

  List<Metadata> getMetadata();

  Thumbnail getThumbnail();

  void setThumbnail(Thumbnail thumbnail);

  String getViewingHint();

  void setViewingHint(String viewingHint);

  List<ManifestReference> getManifests();

  void setManifests(List<ManifestReference> manifests);

  List<CollectionReference> getSubCollections();

  void setSubCollections(List<CollectionReference> collections);
}
