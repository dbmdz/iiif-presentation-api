package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.PropertyValue;

import java.util.*;

public class PropertyValueLocalizedImpl implements PropertyValue {
  private Map<Locale, String> localizations;

  public PropertyValueLocalizedImpl() {
    this.localizations = new HashMap<>();
  }

  public PropertyValueLocalizedImpl(Locale language, String value) {
    super();
    setValue(language, value);
  }

  public Set<Locale> getLocalizations() {
    return this.localizations.keySet();
  }

  public void setValue(String value) {
    this.setValue(Locale.getDefault(), value);
  }

  public void setValue(String languageTag, String value) {
    setValue(Locale.forLanguageTag(languageTag), value);
  }

  public void setValue(Locale language, String value) {
    this.localizations.put(language, value);
  }

  @Override
  public String getValue() {
    // TODO: Use hardcoded (english?) default locale instead?
    String value = getValue(Locale.getDefault());
    if (value == null) {
      value = localizations.entrySet().iterator().next().getValue();
    }
    return value;
  }

  public String getValue(String language) {
    return localizations.get(Locale.forLanguageTag(language));
  }

  public String getValue(Locale locale) {
    return localizations.get(locale);
  }
}
