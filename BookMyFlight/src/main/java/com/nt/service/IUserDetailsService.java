package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.model.Reservation;
import com.nt.model.UserDetails;

public interface IUserDetailsService {

	public UserDetails saveUserDetails(UserDetails userDetails);
	public Map<String, Object> checkUserCredentials(String username, String password);
	public boolean deleteUserById(Integer id);
	public boolean updateUserPasswordById(Integer userId, String password);
	
}
