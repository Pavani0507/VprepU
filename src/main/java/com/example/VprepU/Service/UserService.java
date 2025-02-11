package com.example.VprepU.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.VprepU.Model.User;
import com.example.VprepU.Repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public User saveUser(User user) {
		user.setCreated_at(LocalDateTime.now());
		return userRepository.save(user);
	}
	public List<User>getAllUsers(){
		return userRepository.findAll();
	}
	public Optional<User> getUserById(int userId) {
		return userRepository.findById(userId);
	}
	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}
	public User saveUser(@PathVariable int userId) {
		
		return userRepository.save(userId);
	}
	
} 
