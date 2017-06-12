package de.digitalcollections.iiif.presentation.model.impl.v2;

import de.digitalcollections.iiif.presentation.model.api.v2.Resource;
import de.digitalcollections.iiif.presentation.model.api.v2.Service;
import java.net.URI;
import java.util.List;

public class ResourceImpl implements Resource {

  protected String format;
  protected URI id;
  private List<Service> services;
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
  public void setId(String id) {
    this.id = URI.create(id);
  }

  @Override
  public void setId(URI id) {
    this.id = id;
  }

  @Override
  public List<Service> getServices() {
    return services;
  }

  @Override
  public void setServices(List<Service> services) {
    this.services = services;
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
