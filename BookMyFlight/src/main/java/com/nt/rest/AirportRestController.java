package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Airport;
import com.nt.service.IAirportService;

@RestController("airportRestController")
@RequestMapping("/airport")
public class AirportRestController {
	
	@Autowired
	private IAirportService airportService;
	
	@PostMapping("/addAirport")
	public ResponseEntity<Airport> addAirport(@RequestBody Airport airportDetails){
		Airport airport=airportService.addAirport(airportDetails);
		if(airport==null) return new ResponseEntity<Airport>(airport, HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<Airport>(airport, HttpStatus.OK);
	}
	
	@GetMapping("/getAllAirport")
	public ResponseEntity<List<Airport>> getAllAirport(){
		List<Airport> airportList=airportService.getAllAirport();
		return new ResponseEntity<List<Airport>>(airportList, HttpStatus.OK);
	}

}
