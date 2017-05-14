package de.digitalcollections.iiif.presentation.model.api.exceptions;

public class InvalidDataException extends Exception {
  public InvalidDataException(String message, Exception e) {
    super(message, e);
  }
}
