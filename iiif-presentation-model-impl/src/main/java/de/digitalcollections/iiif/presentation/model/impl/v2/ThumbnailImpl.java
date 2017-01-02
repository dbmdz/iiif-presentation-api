package de.digitalcollections.iiif.presentation.model.impl.v2;

import de.digitalcollections.iiif.presentation.model.api.v2.Service;
import de.digitalcollections.iiif.presentation.model.api.v2.Thumbnail;
import java.net.URI;

public class ThumbnailImpl implements Thumbnail {

  protected URI id;
  protected Service service;

  public ThumbnailImpl() {
  }

  public ThumbnailImpl(URI id) {
    this.id = id;
  }

  @Override
  public URI getId() {
    return id;
  }

  @Override
  public void setId(URI id) {
    this.id = id;
  }

  @Override
  public Service getService() {
    return service;
  }

  @Override
  public void setService(Service service) {
    this.service = service;
  }
}
