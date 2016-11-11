package de.digitalcollections.iiif.presentation.model.impl.v2;

import de.digitalcollections.iiif.presentation.model.api.v2.IiifResource;
import de.digitalcollections.iiif.presentation.model.api.v2.PropertyValue;
import de.digitalcollections.iiif.presentation.model.api.v2.SeeAlso;
import de.digitalcollections.iiif.presentation.model.api.v2.Service;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public abstract class AbstractIiifResourceImpl implements IiifResource {

  protected PropertyValue attribution; // optional
  protected String license; // optional
  protected String logo; // optional
  protected String type; // required
  protected String related; // optional
  protected Service service; // optional
  protected List<SeeAlso> seeAlso; // optional
  protected URI within; // optional
  protected URI id; // optional

  @Override
  public PropertyValue getAttribution() {
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
  public void setAttribution(PropertyValue attribution) {
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
  public List<SeeAlso> getSeeAlso() {
    return seeAlso;
  }

  @Override
  public void setSeeAlso(List<SeeAlso> seeAlso) {
    this.seeAlso = seeAlso;
  }

  @Override
  public URI getWithin() {
    return within;
  }

  @Override
  public void setWithin(URI within) {
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
