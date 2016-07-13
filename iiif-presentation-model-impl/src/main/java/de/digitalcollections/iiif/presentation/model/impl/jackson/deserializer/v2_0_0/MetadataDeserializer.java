package de.digitalcollections.iiif.presentation.model.impl.jackson.deserializer.v2_0_0;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.MetadataImpl;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.MetadataMultilanguageImpl;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.MetadataSimpleImpl;
import java.io.IOException;

public class MetadataDeserializer extends StdDeserializer<MetadataImpl> {

  public MetadataDeserializer() {
    super(MetadataImpl.class);
  }

  @Override
  public MetadataImpl deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
    ObjectMapper mapper = (ObjectMapper) jp.getCodec();
    ObjectNode root = (ObjectNode) mapper.readTree(jp);

    JsonNode value = root.get("value");
    if (TextNode.class.isAssignableFrom(value.getClass())) {
      return mapper.convertValue(root, MetadataSimpleImpl.class);
    } else {
      return mapper.convertValue(root, MetadataMultilanguageImpl.class);
    }
  }

}
