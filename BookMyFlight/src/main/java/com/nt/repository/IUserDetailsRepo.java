package com.nt.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.nt.model.UserDetails;

public interface IUserDetailsRepo extends CrudRepository<UserDetails, Integer> {
	//Find user by email
    public Optional<UserDetails> findByEmail(String username);
}
