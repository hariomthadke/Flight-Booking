package com.nt.dto;

import java.util.List;

import com.nt.model.Traveller;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class ReservationDTO {

	private Integer userId;
	private Integer flightId;
	private List<Traveller> travellerList;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getFlightId() {
		return flightId;
	}
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	public List<Traveller> getTravellerList() {
		return travellerList;
	}
	public void setTravellerList(List<Traveller> travellerList) {
		this.travellerList = travellerList;
	}
	
	
}
