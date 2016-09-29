package de.digitalcollections.iiif.presentation.model.impl.v2_0_0;

import de.digitalcollections.iiif.presentation.model.api.v2_0_0.PropertyValue;

import java.util.*;

public class PropertyValueLocalizedImpl implements PropertyValue {
  private Map<Locale, List<String>> localizations;

  public PropertyValueLocalizedImpl() {
    this.localizations = new HashMap<>();
  }

  public PropertyValueLocalizedImpl(Locale language, String value) {
    this();
    addValue(language, value);
  }

  public void addValue(String language, String value) {
    addValue(Locale.forLanguageTag(language), value);
  }

  public void addValue(Locale language, String value) {
    if (!this.localizations.containsKey(language)) {
      this.localizations.put(language, new ArrayList<>());
    }
    this.localizations.get(language).add(value);
  }

  public Set<Locale> getLocalizations() {
    return this.localizations.keySet();
  }

  @Override
  public List<String> getValues() {
    // TODO: Use hardcoded (english?) default locale instead?
    List<String> values = getValues(Locale.getDefault());
    if (values == null) {
      values = localizations.entrySet().iterator().next().getValue();
    }
    return values;
  }

  public List<String> getValues(String language) {
    return localizations.get(Locale.forLanguageTag(language));
  }

  public List<String> getValues(Locale locale) {
    return localizations.get(locale);
  }
}
