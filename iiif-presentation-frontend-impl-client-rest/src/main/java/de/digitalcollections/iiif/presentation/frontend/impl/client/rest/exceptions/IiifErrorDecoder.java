package de.digitalcollections.iiif.presentation.frontend.impl.client.rest.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class IiifErrorDecoder implements ErrorDecoder {

  @Override
  public Exception decode(String methodKey, Response response) {
    final int status = response.status();
    if (400 <= status && status < 500) {
      return new HttpClientException(methodKey, response);
    } else if (500 <= status && status < 600) {
      return new HttpServerException(methodKey, response);
    }
    return new HttpException(methodKey, response);
  }

}
