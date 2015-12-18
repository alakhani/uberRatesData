package com.personal.uberApi.uberRatesData;

import com.personal.uberApi.model.ResponseFareData;

import feign.Feign;
import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public class UberRatesServiceImpl {
	
	public ResponseFareData executeUberFareSearch(String startLatitude, String startLongitude, String endLatitude, String endLongitude) {
		
		Decoder decoder = new GsonDecoder();
		Encoder encoder = new GsonEncoder();
		UberRatesService ratesDataService = Feign.builder()
				.decoder(decoder)
				.encoder(encoder)
				.errorDecoder(new GenericErrorDecoder(decoder))
				.logger(new Logger.ErrorLogger())
				.logLevel(Logger.Level.BASIC)
				.target(UberRatesService.class, "https://api.uber.com");
		
		System.out.println("Fetching Results");
		ResponseFareData faresList = ratesDataService.getRates("37.625732", "-122.377807", "37.785114", "-122.406677");
		System.out.println("Response Returned");
		
		return faresList;
	}
}
