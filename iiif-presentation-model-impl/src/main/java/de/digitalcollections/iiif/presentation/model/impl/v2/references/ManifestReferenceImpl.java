package de.digitalcollections.iiif.presentation.model.impl.v2.references;

import java.net.URI;

import de.digitalcollections.iiif.presentation.model.api.v2.PropertyValue;
import de.digitalcollections.iiif.presentation.model.api.v2.references.ManifestReference;

public class ManifestReferenceImpl extends IiifReferenceImpl implements ManifestReference {
  public ManifestReferenceImpl(URI id) {
    super(id);
  }

  public ManifestReferenceImpl(URI id, PropertyValue label) {
    super(id, label);
  }

  @Override
  public String getType() {
    return "sc:Manifest";
  }
}
