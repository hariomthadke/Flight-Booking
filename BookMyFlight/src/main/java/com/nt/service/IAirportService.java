package com.nt.service;

import java.util.List;

import com.nt.model.Airport;

public interface IAirportService {
	public Airport addAirport(Airport airportDetails);
	public List<Airport> getAllAirport();

}
