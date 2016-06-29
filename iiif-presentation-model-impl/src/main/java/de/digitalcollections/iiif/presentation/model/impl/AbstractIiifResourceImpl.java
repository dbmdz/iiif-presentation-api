package de.digitalcollections.iiif.presentation.model.impl;

import de.digitalcollections.iiif.presentation.model.api.IiifResource;
import de.digitalcollections.iiif.presentation.model.api.Service;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public abstract class AbstractIiifResourceImpl implements IiifResource {

  protected String attribution; // optional
  protected String license; // optional
  protected String logo; // optional
  protected String type; // required
  protected String related; // optional
  protected Service service; // optional
  protected List<String> seeAlso; // optional
  protected String within; // optional
  protected URI id; // optional

  @Override
  public String getAttribution() {
    return attribution;
  }

  @Override
  public String getLicense() {
    return license;
  }

  @Override
  public String getLogo() {
    return logo;
  }

  @Override
  public void setAttribution(String attribution) {
    this.attribution = attribution;
  }

  @Override
  public void setLicense(String license) {
    this.license = license;
  }

  @Override
  public void setLogo(String logo) {
    this.logo = logo;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public String getRelated() {
    return related;
  }

  @Override
  public void setRelated(String related) {
    this.related = related;
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
  public List<String> getSeeAlso() {
    return seeAlso;
  }

  @Override
  public void setSeeAlso(List<String> seeAlso) {
    this.seeAlso = seeAlso;
  }

  @Override
  public String getWithin() {
    return within;
  }

  @Override
  public void setWithin(String within) {
    this.within = within;
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
  public void setId(String id) throws URISyntaxException {
    this.id = new URI(id);
  }

}
