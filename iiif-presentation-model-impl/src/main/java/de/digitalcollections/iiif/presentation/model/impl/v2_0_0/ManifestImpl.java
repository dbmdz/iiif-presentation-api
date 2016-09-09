package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class ManifestImpl extends AbstractIiifResourceImpl implements Manifest {

  private final String context = "http://iiif.io/api/presentation/2/context.json";
  private String description; // recommended
  private PropertyValue label; // required
  private List<Metadata> metadata; // recommended
  private List<Sequence> sequences;
  private List<Range> structures;
  private Thumbnail thumbnail; // recommended
  private String viewingDirection; // optional
  private String viewingHint; // optional

  public ManifestImpl() {
  }

  public ManifestImpl(URI id, PropertyValue label) {
    assert id != null;
    assert label != null;

    this.id = id;
    this.label = label;

    this.type = "sc:Manifest";
  }

  public ManifestImpl(String id, PropertyValue label) throws URISyntaxException {
    this(new URI(id), label);
  }

  /**
   *
   * @param id The URI that identifies the resource. It is recommended that an HTTP URI be used for all resources.
   * Recommended HTTP URI patterns for the different classes of resource are given below. URIs from any registered
   * scheme may be used, and implementers may find it convenient to use a UUID URN of the form:
   * "urn:uuid:uuid-goes-here-1234". Resources that do not require URIs may be assigned blank node identifiers; this is
   * the same as omitting @id. A manifest must have an id, and it must be the http(s) URI at which the manifest is
   * published.
   * @param label A human readable label, name or title for the resource. This property is intended to be displayed as a
   * short, textual surrogate for the resource if a human needs to make a distinction between it and similar resources,
   * for example between pages or between a choice of images to display. A manifest must have a label, and it should be
   * the name of the object or title of the intellectual work that it embodies.
   * @param description A longer-form prose description of the object or resource that the property is attached to,
   * intended to be conveyed to the user as a full text description, rather than a simple label and value. It may be in
   * simple HTML or plain text. It can duplicate any of the information from the metadata fields, along with additional
   * information required to understand what is being displayed. Clients should have a way to display the descriptions
   * of manifests and canvases, and may have a way to view the information about other resources. A manifest should have
   * a description that describes the object or work.
   * @param metadata A list of short descriptive entries, given as pairs of human readable label and value to be
   * displayed to the user. The value should be either simple HTML, including links and text markup, or plain text, and
   * the label should be plain text. There are no semantics conveyed by this information, and clients should not use it
   * for discovery or other purposes. This list of descriptive pairs should be able to be displayed in a tabular form in
   * the user interface. Clients should have a way to display the information about manifests and canvases, and may have
   * a way to view the information about other resources. The client should display the pairs in the order provided by
   * the description. A pair might be used to convey the author of the work, information about its creation, a brief
   * physical description, or ownership information, amongst other use cases. The client is not expected to take any
   * action on this information beyond displaying the label and value. An example pair of label and value might be a
   * label of “Author” and a value of "Jehan Froissart". A manifest should have metadata pairs associated with it
   * describing the object or work.
   * @param thumbnail A small image that depicts or pictorially represents the resource that the property is attached
   * to, such as the title page, a significant image or rendering of a canvas with multiple content resources associated
   * with it. It is recommended that a IIIF Image API service be available for this image for manipulations such as
   * resizing. A manifest should have a thumbnail image that represents the entire object or work.
   */
  public ManifestImpl(URI id, PropertyValue label, String description, List<Metadata> metadata, Thumbnail thumbnail) {
    this(id, label);

    this.description = description;
    this.metadata = metadata;
    this.thumbnail = thumbnail;
  }

  @Override
  public String getContext() {
    return context;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public PropertyValue getLabel() {
    return label;
  }

  @Override
  public void setLabel(PropertyValue label) {
    this.label = label;
  }

  @Override
  public List<Metadata> getMetadata() {
    return metadata;
  }

  @Override
  public void setMetadata(List<Metadata> metadata) {
    this.metadata = metadata;
  }

  @Override
  public List<Sequence> getSequences() {
    return sequences;
  }

  @Override
  public void setSequences(List<Sequence> sequences) {
    this.sequences = sequences;
  }

  @Override
  public Thumbnail getThumbnail() {
    return thumbnail;
  }

  @Override
  public void setThumbnail(Thumbnail thumbnail) {
    this.thumbnail = thumbnail;
  }

  @Override
  public String getViewingDirection() {
    return viewingDirection;
  }

  @Override
  public void setViewingDirection(String viewingDirection) {
    this.viewingDirection = viewingDirection;
  }

  @Override
  public String getViewingHint() {
    return viewingHint;
  }

  @Override
  public void setViewingHint(String viewingHint) {
    this.viewingHint = viewingHint;
  }

  @Override
  public List<Range> getStructures() {
    return structures;
  }

  @Override
  public void setRanges(List<Range> structures) {
    this.structures = structures;
  }

  @Override
  public void setStructures(List<Range> structures) {
    this.structures = structures;
  }
}
