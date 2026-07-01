package com.example.securityDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.securityDemo.entity.User;
import com.example.securityDemo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public String login(User loginUser) {
		User user= userRepository.findByName(loginUser.getName());
				
		if(user == null) return "User not found";
		
		if(passwordEncoder.matches(loginUser.getPassword(), user.getPassword()))
				return "Login successfully";
		else return "Invalid Password";
		}
	
	public User saveUser(User user) {
		
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		return userRepository.save(user);
		
	}
	
}
