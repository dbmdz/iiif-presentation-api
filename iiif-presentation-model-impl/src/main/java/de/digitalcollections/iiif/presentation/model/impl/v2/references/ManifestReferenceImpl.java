package de.digitalcollections.iiif.presentation.model.impl.v2.references;

import de.digitalcollections.iiif.presentation.model.api.v2.PropertyValue;
import de.digitalcollections.iiif.presentation.model.api.v2.references.ManifestReference;
import java.net.URI;

public class ManifestReferenceImpl extends IiifReferenceImpl implements ManifestReference {

  private String type = "sc:Manifest";

  public ManifestReferenceImpl() {
    this(null);
  }

  public ManifestReferenceImpl(URI id) {
    super(id);
  }

  public ManifestReferenceImpl(URI id, PropertyValue label) {
    super(id, label);
  }

  @Override
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
