package com.datazuul.iiif.presentation.api.model;

/**
 * @author ralf
 */
public enum Version {
  V1, V2;

  public static Version getVersion(String context) {
    if (context == null) {
      return null;
    }

    switch (context) {
      case "http://www.shared-canvas.org/ns/context.json":
        return V1;
      case "http://iiif.io/api/presentation/2/context.json":
        return V2;
      default:
        return null;
    }
  }
}
