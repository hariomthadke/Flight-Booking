package com.nt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Reservation;
import com.nt.model.UserDetails;
import com.nt.repository.IUserDetailsRepo;

@Service
public class UserDetailsServiceImpl implements IUserDetailsService {

	@Autowired
	private IUserDetailsRepo repo;
	
	@Override
	public UserDetails saveUserDetails(UserDetails userDetails) {
		UserDetails user=null;
		try {
		user=repo.save(userDetails);
		}catch(Exception e) {
			return null;
		}
		return user;
		
	}
	@Override
	public Map<String, Object> checkUserCredentials(String username, String password) {
		Optional<UserDetails> userDetails=repo.findByEmail(username);
		Map<String, Object> hashMap=new HashMap<>();
		if(userDetails.isPresent()) {
			UserDetails user=userDetails.get();
			hashMap.put("id", user.getUserId());
			hashMap.put("name", user.getName());
			hashMap.put("email", user.getEmail());
			hashMap.put("role", user.getRole());
			hashMap.put("mobNo", user.getMobNo());
			hashMap.put("status", "success");
			return hashMap;
		}else {
		   hashMap.put("status", "error");
		   return hashMap;
		}
	}
	@Override
	public boolean deleteUserById(Integer id) {
		Optional<UserDetails> userDetails=repo.findById(id);
		if(userDetails.isPresent()) {
		repo.deleteById(id);
		}else {
			return false;
		}
		return true;
	}
	@Override
	public boolean updateUserPasswordById(Integer userId, String password) {
		Optional<UserDetails> userDetails=repo.findById(userId);
		if(userDetails.isPresent()) {
		    UserDetails user=userDetails.get();
		    user.setPassword(password);
		    try {
		      repo.save(user);
		     }catch(Exception e) {
		    	return false;
		    }
		}else {
			return false;
		}
		return true;
	}


}
