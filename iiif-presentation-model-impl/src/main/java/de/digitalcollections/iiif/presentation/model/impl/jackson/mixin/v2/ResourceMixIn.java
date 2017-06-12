package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.digitalcollections.iiif.presentation.model.api.v2.Service;
import de.digitalcollections.iiif.presentation.model.impl.jackson.serializer.v2.ServiceCollectionSerializer;
import de.digitalcollections.iiif.presentation.model.impl.v2.ResourceImpl;
import java.util.List;

@JsonDeserialize(as = ResourceImpl.class)
public abstract class ResourceMixIn extends AbstractIiifResourceMixIn {
  @JsonProperty("service")
  @JsonSerialize(using = ServiceCollectionSerializer.class)
  abstract List<Service> getServices();
}
