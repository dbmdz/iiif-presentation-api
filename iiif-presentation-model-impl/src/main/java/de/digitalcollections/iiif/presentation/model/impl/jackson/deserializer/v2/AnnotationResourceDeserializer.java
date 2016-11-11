package de.digitalcollections.iiif.presentation.model.impl.jackson.deserializer.v2;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import de.digitalcollections.iiif.presentation.model.api.v2.AnnotationResource;
import de.digitalcollections.iiif.presentation.model.impl.v2.AnnotationResourceCharsImpl;
import de.digitalcollections.iiif.presentation.model.impl.v2.AnnotationResourceImpl;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AnnotationResourceDeserializer extends JsonDeserializer<AnnotationResource> {

  @Override
  public AnnotationResource deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
    AnnotationResource result;
    ObjectMapper mapper = (ObjectMapper) jp.getCodec();
    TreeNode node = mapper.readTree(jp);
    String format = ((TextNode) node.get("format")).textValue();

    String id = null;
    TextNode idNode = (TextNode) node.get("@id");
    if (idNode != null) {
      id = idNode.textValue();
    }

    String type = ((TextNode) node.get("@type")).textValue();
    if (node.get("chars") != null) {
      result = new AnnotationResourceCharsImpl(type, format);
      String chars = ((TextNode) node.get("chars")).textValue();
      ((AnnotationResourceCharsImpl) result).setChars(chars);
    } else {
      result = new AnnotationResourceImpl(type, format);
    }
    if (id != null) {
      try {
        result.setId(new URI(id));
      } catch (URISyntaxException ex) {
      }
    }
    return result;
  }

}
