package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.references;


import de.digitalcollections.iiif.presentation.model.impl.v2.references.ManifestReferenceImpl;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonDeserialize(as = ManifestReferenceImpl.class)
public abstract class ManifestReferenceMixin {
}
