package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.digitalcollections.iiif.presentation.model.api.v2.Service;
import de.digitalcollections.iiif.presentation.model.impl.jackson.serializer.v2.ServiceCollectionSerializer;
import java.util.List;

public abstract class AbstractIiifResourceMixIn {

  @JsonProperty("@id")
  abstract String getId();

  @JsonProperty("@type")
  abstract String getType();

  @JsonIgnore
  abstract void setId(String id);

  @JsonProperty("service")
  @JsonSerialize(using = ServiceCollectionSerializer.class)
  abstract List<Service> getServices();
}
