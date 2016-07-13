package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import java.util.Locale;

public class MetadataLocalizedValueImpl {

  private final String value;
  private final String language;

  public MetadataLocalizedValueImpl(String value, Locale locale) {
    this.value = value;
    this.language = locale.getLanguage();
  }

  public MetadataLocalizedValueImpl(String value, String language) {
    this.value = value;
    this.language = language;
  }

  public String getValue() {
    return value;
  }

  public String getLanguage() {
    return language;
  }
}
