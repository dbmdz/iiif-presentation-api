package de.digitalcollections.iiif.presentation.business.api.v2;

import de.digitalcollections.iiif.presentation.business.api.exceptions.NotFoundException;
import de.digitalcollections.iiif.presentation.model.api.v2.Collection;
import de.digitalcollections.iiif.presentation.model.api.v2.Manifest;

/**
 * Service for IIIF Presentation API functionality.
 */
public interface PresentationService {

  /**
   * @param name unique name of collection
   * @return Collection specified by name
   * @throws NotFoundException if no collection found or access disallowed
   */
  Collection getCollection(String name) throws NotFoundException;

  /**
   * @param identifier unique id for IIIF resource
   * @return Manifest specifying presentation for IIIF resource
   * @throws de.digitalcollections.iiif.presentation.business.api.exceptions.NotFoundException if no manifest found or
   * access disallowed
   */
  Manifest getManifest(String identifier) throws NotFoundException;

}
