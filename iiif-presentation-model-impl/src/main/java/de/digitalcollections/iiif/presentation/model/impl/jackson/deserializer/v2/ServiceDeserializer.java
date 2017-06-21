package de.digitalcollections.iiif.presentation.model.impl.jackson.deserializer.v2;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.TextNode;
import de.digitalcollections.iiif.presentation.model.api.v2.Service;
import de.digitalcollections.iiif.presentation.model.impl.v2.PhysicalDimensionsServiceImpl;
import de.digitalcollections.iiif.presentation.model.impl.v2.ServiceImpl;
import java.io.IOException;

public class ServiceDeserializer extends JsonDeserializer<Service> {
  private String getAsString(TreeNode parent, String key) {
    TreeNode node = parent.get(key);
    if (node != null) {
      return ((TextNode) node).textValue();
    } else {
      return null;
    }
  }

  @Override
  public Service deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    ObjectMapper mapper = (ObjectMapper) jp.getCodec();
    TreeNode node = mapper.readTree(jp);
    String profile = null;
    Object profileObj = node.get("profile");
    if (profileObj != null) {
      profile = ((TextNode) profileObj).textValue();
    }
    
    if(profile == null) {
      return null;
    }

    if (profile.contains("physdim")) {
      PhysicalDimensionsServiceImpl service = new PhysicalDimensionsServiceImpl();
      service.setContext(getAsString(node, "@context"));
      service.setProfile(getAsString(node, "profile"));
      service.setPhysicalScale(((DoubleNode) node.get("physicalScale")).asDouble());
      service.setPhysicalUnits(getAsString(node, "physicalUnits"));
      return service;
    } else {
      ServiceImpl service = new ServiceImpl();
      service.setContext(getAsString(node, "@context"));
      service.setProfile(getAsString(node, "profile"));
      service.setId(getAsString(node, "@id"));
      return service;
    }
  }
}
