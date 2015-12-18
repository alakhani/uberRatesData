package com.personal.uberApi.uberRatesData;

public class GenericClientError extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message; // parsed from json

	@Override
	public String getMessage() {
		return message;
	}
}
