package com.datazuul.iiif.presentation.api.json;

import com.datazuul.iiif.presentation.api.model.other.Metadata;
import com.datazuul.iiif.presentation.api.model.other.MetadataMultilanguage;
import com.datazuul.iiif.presentation.api.model.other.MetadataSimple;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.io.IOException;

/**
 *
 * @author Ralf Eichinger (ralf.eichinger at bsb-muenchen.de)
 */
public class MetadataDeserializer extends StdDeserializer<Metadata> {

  public MetadataDeserializer() {
    super(Metadata.class);
  }

  @Override
  public Metadata deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
    ObjectMapper mapper = (ObjectMapper) jp.getCodec();
    ObjectNode root = (ObjectNode) mapper.readTree(jp);

    JsonNode value = root.get("value");
    if (TextNode.class.isAssignableFrom(value.getClass())) {
      return mapper.convertValue(root, MetadataSimple.class);
    } else {
      return mapper.convertValue(root, MetadataMultilanguage.class);
    }
  }

}
