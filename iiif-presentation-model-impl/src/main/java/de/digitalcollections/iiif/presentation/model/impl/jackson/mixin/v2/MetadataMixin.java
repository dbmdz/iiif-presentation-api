package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.v2.MetadataImpl;

@JsonDeserialize(as = MetadataImpl.class)
public abstract class MetadataMixin {
}
