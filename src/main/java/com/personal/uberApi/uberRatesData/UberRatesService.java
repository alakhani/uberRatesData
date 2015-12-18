package com.personal.uberApi.uberRatesData;

import com.personal.uberApi.model.ResponseFareData;

import feign.Param;
import feign.RequestLine;

public interface UberRatesService {
	@RequestLine("GET /v1/estimates/price?start_latitude={start_latitude}&start_longitude={start_longitude}&end_latitude={end_latitude}"
					+ "&end_longitude={end_longitude}&server_token=enterYourTokenHere")
	ResponseFareData getRates(@Param("start_latitude") String start_latitude, @Param("start_longitude") String start_longitude,
			@Param("end_latitude") String end_latitude, @Param("end_longitude") String end_longitude);
}
