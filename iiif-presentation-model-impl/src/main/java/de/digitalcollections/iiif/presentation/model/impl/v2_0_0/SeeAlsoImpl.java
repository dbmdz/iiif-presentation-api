package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import java.net.URI;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.SeeAlso;

public class SeeAlsoImpl implements SeeAlso {
  private URI id;
  private String format;
  private URI profile;

  @Override
  public URI getId() {
    return id;
  }

  @Override
  public void setId(URI uri) {
    this.id = id;
  }

  @Override
  public String getFormat() {
    return this.format;
  }

  @Override
  public void setFormat(String fmt) {
    this.format = fmt;
  }

  @Override
  public URI getProfile() {
    return this.profile;
  }

  @Override
  public void setProfile(URI uri) {
    this.profile = uri;
  }
}
