package com.nt.model;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="flight")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_seq")
    @SequenceGenerator(name = "flight_seq", sequenceName = "FLIGHT_SEQ", allocationSize = 1)
    @Column(name = "flightId")
    private Integer flightId;

    private String flightName;
    @ManyToOne(targetEntity=Airport.class,fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(referencedColumnName="airportId")
    @JsonIgnore
    private Airport originAirport;
     
    @ManyToOne(targetEntity=Airport.class,fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(referencedColumnName="airportId")
    @JsonIgnore
    private Airport destinationAirport;
    
    private Timestamp departureDate;

    private Double price;
    private Integer availableSeats;
    
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public Integer getFlightId() {
		return flightId;
	}
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	public Airport getOriginAirport() {
		return originAirport;
	}
	public void setOriginAirport(Airport originAirport) {
		this.originAirport = originAirport;
	}
	public Airport getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
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
	public Integer getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}
    
    
}

