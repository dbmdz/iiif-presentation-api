package de.digitalcollections.iiif.presentation.model.api;

import java.net.URI;

public interface Image {

  URI getId();

  String getMotivation();

  URI getOn();

  void setOn(URI on);

  ImageResource getResource();

  void setResource(ImageResource resource);

  String getType();

}
