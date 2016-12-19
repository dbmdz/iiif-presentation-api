package de.digitalcollections.iiif.presentation.frontend.impl.client.rest.exceptions;

import feign.Response;

public class HttpException extends RuntimeException {

  public HttpException(String methodKey, Response response) {
    super(String.format("Got %d for backend call %s.%n⤷ %s",
        response.status(), methodKey, response.request()));
  }

}
