package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Content;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Metadata;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.PropertyValue;
import de.digitalcollections.iiif.presentation.model.api.v2_0_0.Thumbnail;
import java.net.URI;
import java.util.List;

public class ContentImpl extends AbstractIiifResourceImpl implements Content {

  protected List<Metadata> metadata; // optional
  protected PropertyValue description; // optional
  protected Thumbnail thumbnail; // optional
  protected String format; // optional
  protected int height; // optional
  protected int width; // optional
  protected String viewingHint; // optional

  /**
   * @param id A content resource must have an id unless it is embedded in the response, and it must be the http(s) URI
   * at which the resource is published.
   */
  public ContentImpl(URI id) {
    assert id != null;
    this.id = id;
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
  public PropertyValue getDescription() {
    return description;
  }

  @Override
  public void setDescription(PropertyValue description) {
    this.description = description;
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
  public String getFormat() {
    return format;
  }

  @Override
  public void setFormat(String format) {
    this.format = format;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public void setWidth(int width) {
    this.width = width;
  }

  @Override
  public String getViewingHint() {
    return viewingHint;
  }

  @Override
  public void setViewingHint(String viewingHint) {
    this.viewingHint = viewingHint;
  }
}
