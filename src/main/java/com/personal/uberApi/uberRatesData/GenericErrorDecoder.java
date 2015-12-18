package com.personal.uberApi.uberRatesData;

import java.io.IOException;

import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;

public class GenericErrorDecoder implements ErrorDecoder{
	final Decoder decoder;
	final ErrorDecoder defaultDecoder = new ErrorDecoder.Default();

	GenericErrorDecoder(Decoder decoder) {
		this.decoder = decoder;
	}

	public Exception decode(String methodKey, Response response) {
		try {
			return (Exception) decoder.decode(response, GenericClientError.class);
		} catch (IOException fallbackToDefault) {
			return defaultDecoder.decode(methodKey, response);
		}
	}
}
