package de.digitalcollections.iiif.presentation.model.api.v2;

import java.net.URI;
import java.util.List;

public interface IiifResource {

  PropertyValue getAttribution();

  /**
   * @param attribution A human readable label that must be displayed when the resource it is associated with is
   * displayed or used. For example, this could be used to present copyright or ownership statements, or simply an
   * acknowledgment of owning and/or publishing institutions. Any resource may have an attribution label.
   */
  void setAttribution(PropertyValue attribution);

  URI getId();

  void setId(String id);

  void setId(URI id);

  String getLicense();

  /**
   * @param license A link to an external resource that describes the license or rights statement under which the
   * resource is being used. The rationale for this being a URI and not a human readable label is that typically there
   * is one license for many resources, and the text is too long to be displayed to the user along with the object. If
   * displaying the text is a requirement, then it is recommended to include the information using the attribution
   * property instead. Any resource type may have one or more licenses associated with it.
   */
  void setLicense(String license);

  String getLogo();

  /**
   * @param logo A small image that represents an individual or organization associated with the resource it is attached
   * to. This could be the logo of the owning or hosting institution. The logo must be clearly rendered when the
   * resource is displayed or used, without cropping, rotating or otherwise distorting the image. It is recommended that
   * a IIIF Image API service be available for this image for manipulations such as resizing. Any resource type may have
   * one or more logos associated with it.
   */
  void setLogo(String logo);

  String getRelated();

  /**
   * @param related A link to an external resource intended to be displayed directly to the user, and is related to the
   * resource that has the related property. Examples might include a video or academic paper about the resource, a
   * website, an HTML description, and so forth. A label and the format of the related resource should be given to
   * assist clients in rendering the resource to the user. Any resource type may have one or more external resources
   * related to it.
   */
  void setRelated(String related);

  List<SeeAlso> getSeeAlso();

  /**
   * @param seeAlso A link to a machine readable document that semantically describes the resource with the seeAlso
   * property, such as an XML or RDF description. This document could be used for search and discovery or inferencing
   * purposes, or just to provide a longer description of the resource. The profile and format properties of the
   * document should be given to help the client to make appropriate use of the document. Any resource type may have one
   * or more external descriptions related to it.
   */
  void setSeeAlso(List<SeeAlso> seeAlso);

  Service getService();

  /**
   * @param service A link to a service that makes more functionality available for the resource, such as from an image
   * to the base URI of an associated IIIF Image API service. The service resource should have additional information
   * associated with it in order to allow the client to determine how to make appropriate use of it, such as a profile
   * link to a service description. It may also have relevant information copied from the service itself. This
   * duplication is permitted in order to increase the performance of rendering the object without necessitating
   * additional HTTP requests. Please see the Service Profiles document for known services. Any resource type may have
   * one or more links to an external service.
   */
  void setService(Service service);

  /**
   * @return The type of the resource. For the resource types defined by this specification, the value of @type will be
   * described in the sections below. For content resources, the type may be drawn from other vocabularies.
   * Recommendations for basic types such as image, text or audio are also given in the sections below.
   *
   * All resource types must have at least one type specified.
   *
   * This requirement applies only to the types described in Section 2. Services, Thumbnails and other resources will
   * have their own requirements.
   */
  String getType();

  URI getWithin();

  /**
   * @param within A link to a resource that contains the current resource, such as annotation lists within a layer.
   * This also allows linking upwards to collections that allow browsing of the digitized objects available.
   *
   * Collections or annotation lists that serve as pages must be within exactly one paged resource. Other resource
   * types, including collections or annotation lists not serving as pages, may be within one or more containing
   * resources.
   */
  void setWithin(URI within);

  List<Rendering> getRendering();
  
  /**
   * @param rendering A link to an external resource intended for display or download by a human user. 
   * This property can be used to link from a manifest, collection or other resource to the preferred viewing 
   * environment for that resource, such as a viewer page on the publisher’s web site. 
   *                  
   * Other uses include a rendering of a manifest as a PDF or EPUB with the images and text of the book, 
   * or a slide deck with images of the museum object. 
   * 
   * A label and the format of the rendering resource must be supplied to allow clients to present the option to the user.
   * 
   * Any resource type may have one or more external rendering resources.
   */
  void setRendering(List<Rendering> rendering);
  
  
}
