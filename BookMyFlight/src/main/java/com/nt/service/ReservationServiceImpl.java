package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.ReservationDTO;
import com.nt.model.Flight;
import com.nt.model.Reservation;
import com.nt.model.Traveller;
import com.nt.model.UserDetails;
import com.nt.repository.IFlightRepo;
import com.nt.repository.IReservationRepo;
import com.nt.repository.ITravellerRepo;
import com.nt.repository.IUserDetailsRepo;

@Service
public class ReservationServiceImpl implements IReservationService {

	@Autowired
	private IReservationRepo repo;
	
	@Autowired
	private IUserDetailsRepo userRepo;
	
	@Autowired
	private IFlightRepo flightRepo;
	
	@Autowired
	private ITravellerRepo travellerRepo;
	
	
	@Override
	public String bookFlightSeats(ReservationDTO reservationDetails) {
		Optional<UserDetails> userDetails=userRepo.findById(reservationDetails.getUserId());
		Optional<Flight> flightDetails=flightRepo.findById(reservationDetails.getFlightId());
		if(userDetails.isPresent() && flightDetails.isPresent()) {
			
			List<Traveller> travellerList=reservationDetails.getTravellerList();
			Flight flight=flightDetails.get();
			if(flight.getAvailableSeats()<travellerList.size()) return "Not Enough Seats";
			
		   try {
			for(int i=0;i<travellerList.size();i++) {
				Traveller traveller=new Traveller();
				traveller.setName(travellerList.get(i).getName());
				traveller.setGender(travellerList.get(i).getGender());
				traveller.setPassportNo(travellerList.get(i).getPassportNo());
				traveller.setAge(travellerList.get(i).getAge());
				Reservation reservation=new Reservation();
				reservation.setTraveller(travellerRepo.save(traveller));
				reservation.setUser(userDetails.get());
				reservation.setFlight(flightDetails.get());
				repo.save(reservation);
			}
		   }catch(Exception e) {
			   return "Something went wrong";
		   }

			
			flight.setAvailableSeats(flight.getAvailableSeats()-travellerList.size());
			flightRepo.save(flight);
			
		}else {
			return "error";
		}
		return "success";
	}


	@Override
	public List<Reservation> getReservationDetailsByUserId(Integer userId) {
		List<Reservation> allReservation=(List<Reservation>) repo.findAll();
		List<Reservation> userReservations=new ArrayList<>();
		
		for(int i=0;i<allReservation.size();i++) {
			Integer uid=allReservation.get(i).getUser().getUserId();
			if(uid==userId) {
				userReservations.add(allReservation.get(i));
			}
		}
		
		return userReservations;
	}

}
