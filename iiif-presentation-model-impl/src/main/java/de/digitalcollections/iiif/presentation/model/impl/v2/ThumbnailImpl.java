package de.digitalcollections.iiif.presentation.model.impl.v2;

import de.digitalcollections.iiif.presentation.model.api.v2.Service;
import de.digitalcollections.iiif.presentation.model.api.v2.Thumbnail;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ThumbnailImpl implements Thumbnail {

  protected URI id;
  protected List<Service> service;

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
  public List<Service> getService() {
    return service;
  }

  @Override
  public void setService(List<Service> service) {
    this.service = service;
  }
  
  @Override
  public void addService(Service serv) {
	  if (this.service == null) {
		  this.service = new ArrayList<Service>();
	  }
	  this.service.add(serv);
  }
}
