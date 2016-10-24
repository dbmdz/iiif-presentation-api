package de.digitalcollections.iiif.presentation.model.impl.jackson.deserializer.v2_0_0;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.references.AnnotationListReference;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.references.IiifReference;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.references.AnnotationListReferenceImpl;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class IiifReferenceDeserializer extends JsonDeserializer<IiifReference> {

  @Override
  public IiifReference deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
    IiifReference result = null;
    ObjectMapper mapper = (ObjectMapper) jp.getCodec();
    TreeNode node = mapper.readTree(jp);
    String id;
    if (ObjectNode.class.isAssignableFrom(node.getClass())) {
      id = ((TextNode) node.get("@id")).textValue();
      String type = ((TextNode) node.get("@type")).textValue();
      if (!"sc:AnnotationList".equals(type)) {
        throw new IllegalArgumentException(String.format("Do not know how to handle reference type '%s'", type));
      }
    } else if (TextNode.class.isAssignableFrom(node.getClass())) {
      id = ((TextNode) node).textValue();
    } else {
      throw new IllegalArgumentException("Reference must be a string or object!");
    }
    try {
      return new AnnotationListReferenceImpl(new URI(id));
    } catch (URISyntaxException e) {
      throw new IllegalArgumentException(String.format("ID is not a valid URI: %s", id));
    }
  }
}
