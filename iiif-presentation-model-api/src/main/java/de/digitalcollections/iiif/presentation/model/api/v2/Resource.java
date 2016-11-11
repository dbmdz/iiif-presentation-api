package de.digitalcollections.iiif.presentation.model.api.v2;

import java.net.URI;
import java.net.URISyntaxException;

public interface Resource {

  String getFormat();

  void setFormat(String format);

  // the URI at which the image can be obtained: "%3A" == ":"
  // {scheme}://{server}{/prefix}/{identifier}/{region}/{size}/{rotation}/{quality}.{format}
  URI getId();

  void setId(URI id);

  void setId(String id) throws URISyntaxException;

  Service getService();

  void setService(Service service);

  String getType();

  void setType(String type);

}
