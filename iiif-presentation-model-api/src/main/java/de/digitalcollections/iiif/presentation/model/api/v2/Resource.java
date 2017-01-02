package de.digitalcollections.iiif.presentation.model.api.v2;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public interface Resource {

  String getFormat();

  void setFormat(String format);

  // the URI at which the image can be obtained: "%3A" == ":"
  // {scheme}://{server}{/prefix}/{identifier}/{region}/{size}/{rotation}/{quality}.{format}
  URI getId();

  void setId(URI id);

  void setId(String id) throws URISyntaxException;

  List<Service> getService();

  void setService(List<Service> service);
  
  public void addService(Service serv); 

  String getType();

  void setType(String type);

}
