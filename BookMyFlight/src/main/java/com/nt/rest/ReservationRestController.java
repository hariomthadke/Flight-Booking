package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.dto.ReservationDTO;
import com.nt.service.IReservationService;

@RestController("reservationRestController")
@RequestMapping("/reservation")
public class ReservationRestController {
	
	@Autowired
	private IReservationService reservationService;
	
	@PostMapping("/bookFlight")
  public ResponseEntity<String> bookFlight(@RequestBody ReservationDTO reservationDetails){
	 String message=reservationService.bookFlightSeats(reservationDetails);
	  if(!message.equalsIgnoreCase("success")) return new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	  
  }

}
