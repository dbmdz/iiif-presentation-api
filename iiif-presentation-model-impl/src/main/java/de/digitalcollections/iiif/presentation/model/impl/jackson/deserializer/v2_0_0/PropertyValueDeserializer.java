package de.digitalcollections.iiif.presentation.model.impl.jackson.deserializer.v2_0_0;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.PropertyValue;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.MetadataImpl;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.PropertyValueLocalizedImpl;
import de.digitalcollections.iiif.presentation.model.impl.v2_0_0.PropertyValueSimpleImpl;

import java.io.IOException;
import java.util.Locale;

public class PropertyValueDeserializer extends JsonDeserializer<PropertyValue> implements ContextualDeserializer {
  private JavaType valueType;

  @Override
  public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
    JavaType wrapperType = property.getType();
    JavaType valueType = wrapperType.containedType(0);
    PropertyValueDeserializer deserializer = new PropertyValueDeserializer();
    deserializer.valueType = valueType;
    return deserializer;
  }

  @Override
  public PropertyValue deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
    ObjectMapper mapper = (ObjectMapper) jp.getCodec();
    TreeNode node = mapper.readTree(jp);

    if (TextNode.class.isAssignableFrom(node.getClass())) {
      return mapper.convertValue(node, PropertyValueSimpleImpl.class);
    } else if (ObjectNode.class.isAssignableFrom(node.getClass())){
      ObjectNode obj = (ObjectNode) node;
      String language = ((TextNode) node.get("@language")).textValue();
      String value = ((TextNode) node.get("@value")).textValue();
      return new PropertyValueLocalizedImpl(Locale.forLanguageTag(language), value);
    } else if (ArrayNode.class.isAssignableFrom(node.getClass())) {
      // FIXME: We currently assume that the values are homogenous (i.e. no mix between strings and objects),
      //        but it seems like the 2.1 specification allows for this:
      //        http://iiif.io/api/presentation/2.1/#language-of-property-values
      //        Prepare for a few horrible days, this might get hairy...
      ArrayNode arr = (ArrayNode) node;
      ObjectNode curObj;
      PropertyValueLocalizedImpl propVal = new PropertyValueLocalizedImpl();
      for (int i=0; i < arr.size(); i++) {
        curObj = (ObjectNode) arr.get(i);
        propVal.setValue(((TextNode) curObj.get("@language")).textValue(),
                         ((TextNode) curObj.get("@value")).textValue());
      }
      return propVal;
    }
    return null;
  }

}
