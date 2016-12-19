package de.digitalcollections.iiif.presentation.frontend.impl.client.rest.exceptions;

import feign.Response;

public class HttpServerException extends HttpException {

  public HttpServerException(String methodKey, Response response) {
    super(methodKey, response);
  }

}
