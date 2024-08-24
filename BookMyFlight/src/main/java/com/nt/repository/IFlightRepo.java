package com.nt.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nt.model.Flight;

public interface IFlightRepo extends CrudRepository<Flight, Integer> {

}
