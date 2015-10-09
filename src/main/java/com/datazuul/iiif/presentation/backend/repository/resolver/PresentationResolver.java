package com.datazuul.iiif.presentation.backend.repository.resolver;

import com.datazuul.iiif.presentation.model.NotFoundException;
import java.net.URI;

public interface PresentationResolver {

  public URI getURI(String identifier) throws NotFoundException;

  public boolean isResolvable(String identifier);
}
