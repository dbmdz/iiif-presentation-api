package de.digitalcollections.iiif.presentation.frontend.impl.client.rest.exceptions;

import feign.Response;

public class HttpClientException extends HttpException {

  public HttpClientException(String methodKey, Response response) {
    super(methodKey, response);
  }

}
