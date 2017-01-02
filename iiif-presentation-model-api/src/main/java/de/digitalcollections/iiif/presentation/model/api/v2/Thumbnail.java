package de.digitalcollections.iiif.presentation.model.api.v2;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * A small image that depicts or pictorially represents the resource that the property is attached to, such as the title
 * page, a significant image or rendering of a canvas with multiple content resources associated with it. It is
 * recommended that a IIIF Image API service be available for this image for manipulations such as resizing.
 */
public interface Thumbnail {

  URI getId();

  /**
   * The ID should be a valid URL to an IIIF Image API endpoint that renders the thumbnail.
   *
   * @param id uri as unique id
   */
  void setId(URI id);

  List<Service> getService();

  void setService(List<Service> service);

  void addService(Service serv);

}
