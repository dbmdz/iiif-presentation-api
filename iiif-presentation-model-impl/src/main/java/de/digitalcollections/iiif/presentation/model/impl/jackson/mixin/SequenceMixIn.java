package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.iiif.presentation.model.impl.SequenceImpl;

@JsonDeserialize(as = SequenceImpl.class)
public abstract class SequenceMixIn extends AbstractIiifResourceMixIn {

}
