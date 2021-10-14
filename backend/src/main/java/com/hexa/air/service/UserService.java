package com.hexa.air.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexa.air.entity.User;
import com.hexa.air.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public String signup(User user) {
		if(!userRepository.existsById(user.getId())) {
			userRepository.save(user);
			return "true";
		}
		else {
			return "false";
		}
	}
	
	public String signin(String id, String password) {
		if(userRepository.existsById(id)) {
			User user = userRepository.getById(id);
			if(user.getPassword().equals(password)) {
				return "true";
			}
			else {
				return "false";
			}
		}
		return "nouser";
	}
	
	public String getUser(String id) {
		if(userRepository.existsById(id)) {
			User user = userRepository.getById(id);
			return user.toString();
		}
		return "No User";
	}
}
