package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2_0_0;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.PropertyValue;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.MetadataImpl;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.PropertyValueSimpleImpl;

@JsonDeserialize(as=MetadataImpl.class)
public abstract class MetadataMixin {
}
