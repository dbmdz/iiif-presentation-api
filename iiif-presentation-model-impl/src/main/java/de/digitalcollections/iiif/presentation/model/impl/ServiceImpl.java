package de.digitalcollections.iiif.presentation.model.impl;

import de.digitalcollections.iiif.presentation.model.api.Service;
import java.net.URI;
import java.net.URISyntaxException;

public class ServiceImpl implements Service {

  protected String context;
  protected URI id;
  protected String label;
  protected String profile;

  public ServiceImpl() {
  }

  public ServiceImpl(URI id) {
    this.id = id;
  }

  public ServiceImpl(String id) throws URISyntaxException {
    this.id = new URI(id);
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
  public void setId(String id) throws URISyntaxException {
    this.id = new URI(id);
  }

  @Override
  public void setId(URI id) {
    this.id = id;
  }

  @Override
  public String getLabel() {
    return label;
  }

  @Override
  public void setLabel(String label) {
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

}
