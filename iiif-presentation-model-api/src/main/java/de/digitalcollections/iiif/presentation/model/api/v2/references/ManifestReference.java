package de.digitalcollections.iiif.presentation.model.api.v2.references;

import java.time.Instant;

public interface ManifestReference extends IiifReference {
	
	  Instant getNavDate();

	  void setNavDate(Instant date);
}
