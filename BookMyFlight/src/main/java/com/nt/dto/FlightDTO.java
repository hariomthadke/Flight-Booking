package com.nt.dto;

import java.sql.Timestamp;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class FlightDTO {

	private String flightName;
	private String destinationAirportId;
	private String originAirportId;
	private Timestamp departureDate;
	private Double price;
	private Integer availabeSeats;
	
	
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getDestinationAirportId() {
		return destinationAirportId;
	}
	public void setDestinationAirportId(String destinationAirportId) {
		this.destinationAirportId = destinationAirportId;
	}
	public String getOriginAirportId() {
		return originAirportId;
	}
	public void setOriginAirportId(String originAirportId) {
		this.originAirportId = originAirportId;
	}
	public Timestamp getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Timestamp departureDate) {
		this.departureDate = departureDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getAvailabeSeats() {
		return availabeSeats;
	}
	public void setAvailabeSeats(Integer availabeSeats) {
		this.availabeSeats = availabeSeats;
	}
	
	
}

