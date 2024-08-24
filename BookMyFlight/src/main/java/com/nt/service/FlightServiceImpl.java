package com.nt.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.FlightDTO;
import com.nt.model.Airport;
import com.nt.model.Flight;
import com.nt.repository.IAirportRepo;
import com.nt.repository.IFlightRepo;

@Service
public class FlightServiceImpl implements IFlightService {

	@Autowired
	private IFlightRepo repo;
	
	@Autowired
	private IAirportRepo airportRepo;

	@Override
	public Flight scheduleNewFlight(FlightDTO flightDetails) {
		Optional<Airport> originAirport=airportRepo.findById(Integer.parseInt(flightDetails.getOriginAirportId()));
		Optional<Airport> destinationAirport=airportRepo.findById(Integer.parseInt(flightDetails.getDestinationAirportId()));
		
		Flight returnFlightDetails=null;
		if(originAirport.isPresent() && destinationAirport.isPresent()) {
			Flight flight=new Flight();
			flight.setOriginAirport(originAirport.get());
			flight.setDestinationAirport(destinationAirport.get());
			flight.setPrice(flightDetails.getPrice());
			flight.setDepartureDate(flightDetails.getDepartureDate());
			flight.setAvailableSeats(flightDetails.getAvailabeSeats());
			flight.setFlightName(flightDetails.getFlightName());
			try {
			returnFlightDetails=repo.save(flight);
			}catch(Exception e){return null;}
		}else {
			return null;
		}
		
		return returnFlightDetails;
	}

	@Override
    public List<Flight> checkFlights(String from, String to, Date date) {
		
		List<Flight> allFlights=(List<Flight>) repo.findAll();
		
		List<Flight> availableFlights=new ArrayList<>();
		
		for(int i=0;i<allFlights.size();i++) {
			Flight flight=allFlights.get(i);
			Airport originAirportDetails=flight.getOriginAirport();
			Airport destinationAirportDetails=flight.getDestinationAirport();
			
			if(originAirportDetails.getCity().equalsIgnoreCase(from) && destinationAirportDetails.getCity().equalsIgnoreCase(to)) {
				Timestamp timeStamp=flight.getDepartureDate();
				int departureDay=timeStamp.getDate();
				int departureMonth=timeStamp.getMonth();
				int departureYear=timeStamp.getYear();
			
				int requestDate=date.getDate();
				int requestMonth=date.getMonth();
				int requestYear=date.getYear();
				
				if(departureYear==requestYear && departureMonth==requestMonth && departureDay==requestDate)
				availableFlights.add(flight);
				
			}
		}
       return availableFlights;
 
    }

}
