package de.digitalcollections.iiif.presentation.model.impl.jackson.serializer.v2;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.digitalcollections.iiif.presentation.model.impl.jackson.v2.IiifPresentationApiObjectMapper;
import java.io.IOException;

/**
 * Custom serializer to enable unwrapping of single-value arrays for individual fields.
 * Using Jackson-builtins only allows to enable this feature for all fields,
 * See https://stackoverflow.com/a/31748653/487903
 */
public class ServiceCollectionSerializer extends JsonSerializer<Object> {
  @Override
  public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
    if (!serializers.getConfig().isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) {
      new IiifPresentationApiObjectMapper().enable(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED).writeValue(gen, value);
    } else {
      gen.writeObject(value);
    }
  }
}
