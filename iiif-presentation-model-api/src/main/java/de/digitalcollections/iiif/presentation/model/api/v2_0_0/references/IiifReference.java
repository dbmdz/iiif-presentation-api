package de.digitalcollections.iiif.presentation.model.api.v2_0_0.references;

import java.net.URI;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.PropertyValue;

public interface IiifReference {
  URI getId();
  String getType();
  PropertyValue getLabel();
}
