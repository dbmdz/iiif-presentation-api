package de.digitalcollections.iiif.presentation.model.impl.v2;

import de.digitalcollections.iiif.presentation.model.api.v2.SeeAlso;
import java.net.URI;

public class SeeAlsoImpl implements SeeAlso {

  private URI id;
  private String format;
  private URI profile;

  public SeeAlsoImpl() {
  }

  public SeeAlsoImpl(String id) {
    this.id = URI.create(id);
  }

  public SeeAlsoImpl(URI id) {
    this.id = id;
  }

  @Override
  public URI getId() {
    return id;
  }

  @Override
  public void setId(URI uri) {
    this.id = uri;
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
