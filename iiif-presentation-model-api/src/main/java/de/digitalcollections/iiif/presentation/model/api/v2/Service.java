package de.digitalcollections.iiif.presentation.model.api.v2;

import java.net.URI;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * A link to a service that makes more functionality available for the resource, such as from an image to the base URI
 * of an associated IIIF Image API service. The service resource should have additional information associated with it
 * in order to allow the client to determine how to make appropriate use of it, such as a profile link to a service
 * description. It may also have relevant information copied from the service itself. This duplication is permitted in
 * order to increase the performance of rendering the object without necessitating additional HTTP requests.</p>
 *
 * <p>
 * Please see the <a href="http://iiif.io/api/annex/services/">Service Profiles document</a> for known services.</p>
 *
 * <p>
 * Services may be included either by reference or embedded within the response. The decision as to whether to embed or
 * reference is left up to the implementer, however embedded descriptions should be kept as short as possible. If the
 * only properties of the object are @context, @id, profile and/or label, then the client should retrieve the resource
 * from the URI given in @id.</p>
 *
 * <p>
 * Example:</p>
 *
 * <pre>
 * {
 *   "service": {
 *     "@context": "http://example.org/ns/jsonld/context.json",
 *     "@id": "http://example.org/service/example.json",
 *     "profile": "http://example.org/docs/example-service.html",
 *     "label": "Example Service"
 *     // Additional keys may be embedded here, if not then the @id should be retrieved
 *   }
 * }
 * </pre>
 */
public interface Service {

  String getContext();

  void setContext(String context);

  URI getId();

  /**
   * @param id Services should have an @id that can be dereferenced, and if so, the representation retrieved from that
   * URI should be JSON-LD. The service at the URI in @id may require additional parameters, generate representations
   * other than JSON-LD, or have no JSON-LD representation at all. If a IIIF Image API service is available for the
   * image, then a link to the service’s base URI should be included.
   */
  void setId(URI id);

  void setId(String id);

  PropertyValue getLabel();

  /**
   * @param label Services may have a label property to provide a human readable string to display to the user in the
   * situation that the service has to be selected or manually linked to rather than automatically processed.
   */
  void setLabel(PropertyValue label);

  String getProfile();

  /**
   * @param profile Services should have a profile URI which can be used to determine the type of service, especially
   * for services that do not provide a JSON-LD representation. The representation retrieved from the profile URI should
   * be a human or machine readable description of the service.
   */
  void setProfile(String profile);

  /**
   * @param services A Service can have a nested service as for example the autocomplete service of a search service
   * see http://iiif.io/api/search/1.0/#service-description-1
   */
  void setServices(List<Service> services);

  List<Service> getServices();

  default void setService(Service service) {
    setServices(Collections.singletonList(service));
  }
}
