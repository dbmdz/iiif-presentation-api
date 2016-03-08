package com.datazuul.iiif.presentation.api.model.other;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * A small image that depicts or pictorially represents the resource that the property is attached to, such as the
 * title page, a significant image or rendering of a canvas with multiple content resources associated with it.
 * It is recommended that a IIIF Image API service be available for this image for manipulations such as resizing.
 */
public class Thumbnail {
  @JsonProperty("@id")
  protected URI id;
  protected Service service;

  /** The ID should be a valid URL to an IIIF Image API endpoint that renders the thmbnail. */
  public void setId(URI id) {
    this.id = id;
  }

//  public void setId(String id) throws URISyntaxException {
//    this.id = new URI(id);
//  }

  public URI getId() {
    return id;
  }

  public Service getService() {
    return service;
  }

  public void setService(Service service) {
    this.service = service;
  }
}
