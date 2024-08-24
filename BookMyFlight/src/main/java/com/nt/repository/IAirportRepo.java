package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.model.Airport;

public interface IAirportRepo  extends CrudRepository<Airport, Integer>{

}
