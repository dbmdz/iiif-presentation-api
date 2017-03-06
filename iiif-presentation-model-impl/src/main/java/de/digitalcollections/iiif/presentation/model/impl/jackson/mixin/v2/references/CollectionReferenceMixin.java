package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.references;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2.CollectionMixIn;
import de.digitalcollections.iiif.presentation.model.impl.v2.references.CollectionReferenceImpl;

@JsonDeserialize(as = CollectionReferenceImpl.class)
public abstract class CollectionReferenceMixin extends CollectionMixIn {
}
