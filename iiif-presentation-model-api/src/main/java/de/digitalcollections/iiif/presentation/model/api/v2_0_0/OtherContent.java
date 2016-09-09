package de.digitalcollections.iiif.presentation.model.api.v2_0_0;

/**
 * <p>
 * Recommended URI pattern: {scheme}://{host}/{prefix}/{identifier}/list/{name}</p>
 */
public interface OtherContent extends Content {

  PropertyValue getLabel();

  void setLabel(PropertyValue label);

}
