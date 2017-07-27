package de.digitalcollections.iiif.presentation.model.impl.jackson.mixin.v2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.digitalcollections.iiif.presentation.model.api.v2.Service;
import de.digitalcollections.iiif.presentation.model.impl.jackson.serializer.v2.ServiceCollectionSerializer;
import de.digitalcollections.iiif.presentation.model.impl.v2.ThumbnailImpl;
import java.util.List;

@JsonDeserialize(as = ThumbnailImpl.class)
public abstract class ThumbnailMixIn {

  @JsonProperty("@id")
  abstract String getId();

  @JsonProperty("service")
  @JsonSerialize(using = ServiceCollectionSerializer.class)
  abstract List<Service> getServices();
}
