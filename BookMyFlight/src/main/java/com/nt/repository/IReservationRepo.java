package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.model.Reservation;

public interface IReservationRepo extends CrudRepository<Reservation, Integer>{

}
