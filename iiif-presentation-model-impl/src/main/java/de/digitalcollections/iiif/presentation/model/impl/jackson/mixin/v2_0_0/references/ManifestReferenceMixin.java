package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0.references;


import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.references.ManifestReferenceImpl;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonDeserialize(as = ManifestReferenceImpl.class)
public abstract class ManifestReferenceMixin {
}
