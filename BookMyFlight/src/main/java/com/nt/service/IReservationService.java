package com.nt.service;

import java.util.List;

import com.nt.dto.ReservationDTO;
import com.nt.model.Reservation;

public interface IReservationService {

	public String bookFlightSeats(ReservationDTO reservationDetails);
	public List<Reservation> getReservationDetailsByUserId(Integer userId);
}
