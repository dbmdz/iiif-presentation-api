package de.digitalcollections.iiif.presentation.model.impl;

import de.digitalcollections.iiif.presentation.model.api.Resource;
import de.digitalcollections.iiif.presentation.model.api.Service;
import java.net.URI;
import java.net.URISyntaxException;

public class ResourceImpl implements Resource {

  protected String format;
  protected URI id;
  private Service service;
  protected String type;

  @Override
  public String getFormat() {
    return format;
  }

  @Override
  public void setFormat(String format) {
    this.format = format;
  }

  @Override
  public URI getId() {
    return id;
  }

  @Override
  public void setId(String id) throws URISyntaxException {
    this.id = new URI(id);
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

  @Override
  public String getType() {
    return type;
  }

  @Override
  public void setType(String type) {
    this.type = type;
  }

}
