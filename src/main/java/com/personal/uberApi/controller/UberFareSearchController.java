package com.personal.uberApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personal.uberApi.model.FareData;
import com.personal.uberApi.model.ResponseFareData;
import com.personal.uberApi.uberRatesData.UberRatesService;


@RestController
public class UberFareSearchController {

	private UberRatesService uberRatesService;

	@Autowired
	public UberFareSearchController(UberRatesService uberRatesService) {
		this.uberRatesService = uberRatesService;
	}

	@RequestMapping("/searchUberFares/")
	public List<FareData> searchUberFares(@RequestParam(value="startLatitude") String startLatitude, @RequestParam(value="startLongitude") String startLongitude,
			@RequestParam(value="endLatitude") String endLatitude, @RequestParam(value="endLongitude") String endLongitude) {
		
		ResponseFareData response = uberRatesService.getRates(startLatitude, startLongitude, endLatitude, endLongitude);

		return response.getFaresList();
	}
}
