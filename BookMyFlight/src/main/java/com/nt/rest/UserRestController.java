package com.nt.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Reservation;
import com.nt.model.UserDetails;
import com.nt.service.IReservationService;
import com.nt.service.IUserDetailsService;

@RestController("userRestController")
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private IUserDetailsService userDetailsService;
	@Autowired
	private IReservationService reservationService;
	
	@GetMapping("/")
	public ResponseEntity<String> returnSuccessMessage(){
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	}

	@PostMapping("/registerUser")
	public ResponseEntity<UserDetails> saveUserDetails(@RequestBody UserDetails userDetails){
		UserDetails user=userDetailsService.saveUserDetails(userDetails);
		if(user==null) return new ResponseEntity<UserDetails>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}

	@GetMapping("/userLogin")
	public ResponseEntity<Map<String, Object>> checkCredentials(@RequestParam String email, @RequestParam String password){
		return new ResponseEntity<Map<String, Object>>(userDetailsService.checkUserCredentials(email, password), HttpStatus.OK) ;

	}
	
	@GetMapping("/deleteUserById")
	  public ResponseEntity<Boolean> getAppUsersById(@RequestParam Integer userId) {
	    return new ResponseEntity<Boolean>(userDetailsService.deleteUserById(userId), HttpStatus.OK);
	  }
	
	@GetMapping("/updatePassword")
	public ResponseEntity<Boolean> updateUserPasswordById(@RequestParam Integer userId, @RequestParam String password){
		return new ResponseEntity<Boolean>(userDetailsService.updateUserPasswordById(userId, password), HttpStatus.OK);
	}

	@GetMapping("/checkMyBooking")
	public ResponseEntity<List<Reservation>> checkBookings(@RequestParam Integer userId){
		List<Reservation> userReservations=reservationService.getReservationDetailsByUserId(userId);
		return new ResponseEntity<List<Reservation>>(userReservations, HttpStatus.OK);
	}


}
