package com.jwt.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.example.entities.User;
import com.jwt.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;
	
	public List<User> getUsers(){
		
		return userRepository.findAll();
	}
	
	public User createUser(User  user) {
		user.setUserId(UUID.randomUUID().toString());
		user.setPassword(encoder.encode(user.getPassword())); 
		return userRepository.save(user);
	}
}
