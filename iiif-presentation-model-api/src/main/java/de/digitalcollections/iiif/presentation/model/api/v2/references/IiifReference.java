package de.digitalcollections.iiif.presentation.model.api.v2.references;

import de.digitalcollections.iiif.presentation.model.api.v2.PropertyValue;
import java.net.URI;

public interface IiifReference {

  URI getId();

  void setId(URI id);

  void setId(String id);

  String getType();

  PropertyValue getLabel();
}
