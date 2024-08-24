package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Airport;
import com.nt.repository.IAirportRepo;

@Service
public class AirportServiceImpl implements IAirportService {

	@Autowired
	private IAirportRepo repo;
	
	@Override
	public Airport addAirport(Airport airportDetails) {
		Airport airport=null;
		try {
			airport=repo.save(airportDetails);
		}catch(Exception e) {
			return null;
		}
		return airport;
	}

	@Override
	public List<Airport> getAllAirport() {
		List<Airport> allAirportList=(List<Airport>) repo.findAll();
		return allAirportList;
	}

}
