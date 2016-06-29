package de.digitalcollections.iiif.presentation.backend.api.resolver;

import de.digitalcollections.iiif.presentation.backend.api.exceptions.NotFoundException;
import java.net.URI;

public interface PresentationResolver {

  public URI getURI(String identifier) throws NotFoundException;

  public boolean isResolvable(String identifier);
}
