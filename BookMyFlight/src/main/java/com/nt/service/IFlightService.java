package com.nt.service;

import java.sql.Date;
import java.util.List;

import com.nt.dto.FlightDTO;
import com.nt.model.Flight;

public interface IFlightService {

	public Flight scheduleNewFlight(FlightDTO flightDetails);
	public List<Flight> checkFlights(String from, String to, Date date);
}
