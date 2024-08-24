package com.nt.rest;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.dto.FlightDTO;
import com.nt.model.Flight;
import com.nt.service.IFlightService;

@RestController("flightRestController")
@RequestMapping("/flight")
public class FlightRestController {
	
	@Autowired
	private IFlightService flightService;
	
	@PostMapping("/scheduleFlight")
	public ResponseEntity<Flight> scheduleFlight(@RequestBody FlightDTO flightDetails){
		Flight flight=flightService.scheduleNewFlight(flightDetails);
		if(flight==null) return new ResponseEntity<Flight>(flight, HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<Flight>(flight, HttpStatus.OK);
	}
	
	@GetMapping("/checkAvailableFlights")
	public ResponseEntity<List<Flight>> checkAvailableFlights(@RequestParam String from, @RequestParam String to, @RequestParam Date date){
		List<Flight> flightList=flightService.checkFlights(from, to, date);
		return new ResponseEntity<List<Flight>>(flightList, HttpStatus.OK);
	
	}

}
