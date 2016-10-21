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
    if (ObjectNode.class.isAssignableFrom(node.getClass())) {
      String id = ((TextNode) node.get("@id")).textValue();
      String type = ((TextNode) node.get("@type")).textValue();
      if ("sc:AnnotationList".equals(type)) {
        try {
          AnnotationListReference alr = new AnnotationListReferenceImpl(new URI(id));
//          alr.setWithin(within);
          result = alr;
        } catch (URISyntaxException ex) {
        }
      }
    } else if (TextNode.class.isAssignableFrom(node.getClass())) {
      String id = ((TextNode) node).textValue();
      try {
        AnnotationListReference alr = new AnnotationListReferenceImpl(new URI(id));
//          alr.setWithin(within);
        result = alr;
      } catch (URISyntaxException ex) {
      }
    } else {
      throw new IllegalArgumentException("can not deserialize given json.");
    }
    return result;
  }

}
