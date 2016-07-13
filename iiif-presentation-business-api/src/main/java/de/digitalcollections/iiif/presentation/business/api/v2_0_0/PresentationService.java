package de.digitalcollections.iiif.presentation.business.api.v2_0_0;

import de.digitalcollections.iiif.presentation.business.api.exceptions.NotFoundException;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Manifest;

/**
 * Service for IIIF Presentation API functionality.
 *
 * @author Ralf Eichinger (ralf.eichinger at gmail.com)
 */
public interface PresentationService {

  /**
   * @param identifier unique id for IIIF resource
   * @return Manifest specifying presentation for IIIF resource
   * @throws de.digitalcollections.iiif.presentation.business.api.exceptions.NotFoundException if no manifest found or
   * access disallowed
   */
  Manifest getManifest(String identifier) throws NotFoundException;

}
