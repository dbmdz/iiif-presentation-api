package de.digitalcollections.iiif.presentation.model.impl.v2;

import de.digitalcollections.iiif.presentation.model.api.v2.PropertyValue;
import de.digitalcollections.iiif.presentation.model.api.v2.Service;
import java.net.URI;

public class ServiceImpl implements Service {

  protected String context;
  protected URI id;
  protected PropertyValue label;
  protected String profile;
  protected Service service;
  
  public ServiceImpl() {
  }

  public ServiceImpl(URI id) {
    this.id = id;
  }

  public ServiceImpl(String id) {
    this.id = URI.create(id);
  }

  @Override
  public String getContext() {
    return context;
  }

  @Override
  public void setContext(String context) {
    this.context = context;
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
  public PropertyValue getLabel() {
    return label;
  }

  @Override
  public void setLabel(PropertyValue label) {
    this.label = label;
  }

  @Override
  public String getProfile() {
    return profile;
  }

  @Override
  public void setProfile(String profile) {
    this.profile = profile;
  }

  @Override
  public void setService(Service service) {
	this.service = service;
  }
  
  @Override
  public Service getService() {
	return service;
  }
}
