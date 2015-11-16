/*
 * Copyright 2015 Ralf Eichinger.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datazuul.iiif.presentation.api.model.other;

import java.util.Locale;

/**
 *
 * @author Ralf Eichinger
 */
public class MetadataLocalizedValue {

  private final String value;
  private final String language;

  public MetadataLocalizedValue(String value, Locale locale) {
    this.value = value;
    this.language = locale.getLanguage();
  }

  public MetadataLocalizedValue(String value, String language) {
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
