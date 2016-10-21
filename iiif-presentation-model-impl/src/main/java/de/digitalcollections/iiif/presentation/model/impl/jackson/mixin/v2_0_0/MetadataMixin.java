package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.MetadataImpl;

@JsonDeserialize(as = MetadataImpl.class)
public abstract class MetadataMixin {
}
