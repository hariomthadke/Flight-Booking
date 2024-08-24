package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.model.Traveller;

public interface ITravellerRepo extends CrudRepository<Traveller, Integer> {

}
