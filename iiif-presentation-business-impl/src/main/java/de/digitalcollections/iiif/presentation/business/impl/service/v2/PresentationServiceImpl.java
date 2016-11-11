package de.digitalcollections.iiif.presentation.business.impl.service.v2;

import de.digitalcollections.iiif.presentation.backend.api.repository.v2.PresentationRepository;
import de.digitalcollections.iiif.presentation.business.api.PresentationSecurityService;
import de.digitalcollections.iiif.presentation.business.api.exceptions.NotFoundException;
import de.digitalcollections.iiif.presentation.business.api.v2.PresentationService;
import de.digitalcollections.iiif.presentation.model.api.v2.Manifest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "PresentationServiceImpl-v2.0.0")
public class PresentationServiceImpl implements PresentationService {

  private static final Logger LOGGER = LoggerFactory.getLogger(PresentationServiceImpl.class);

  @Autowired
  private PresentationRepository presentationRepository;

  @Autowired(required = false)
  private PresentationSecurityService presentationSecurityService;

  @Override
  public Manifest getManifest(String identifier) throws NotFoundException {
    if (presentationSecurityService != null && !presentationSecurityService.isAccessAllowed(identifier)) {
      LOGGER.info("Access to manifest for object '{}' is not allowed!", identifier);
      throw new NotFoundException(); // TODO maybe throw an explicitely access disallowed exception
    }
    LOGGER.info("Access to manifest for object '{}' is allowed.", identifier);
    try {
      return presentationRepository.getManifest(identifier);
    } catch (de.digitalcollections.iiif.presentation.backend.api.exceptions.NotFoundException ex) {
      LOGGER.info("Manifest for '{}' not found.", identifier);
      throw new NotFoundException(ex.getMessage());
    }
  }

}
