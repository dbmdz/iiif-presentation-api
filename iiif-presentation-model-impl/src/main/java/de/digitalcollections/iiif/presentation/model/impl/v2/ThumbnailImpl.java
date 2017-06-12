package de.digitalcollections.iiif.presentation.model.impl.v2;

import de.digitalcollections.iiif.presentation.model.api.v2.Service;
import de.digitalcollections.iiif.presentation.model.api.v2.Thumbnail;
import java.net.URI;
import java.util.List;

public class ThumbnailImpl implements Thumbnail {

  protected URI id;
  private List<Service> services;

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
  public List<Service> getServices() {
    return this.services;
  }

  @Override
  public void setServices(List<Service> services) {
    this.services = services;

  }
}
