package com.example.VprepU.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.VprepU.Model.User;
import com.example.VprepU.Service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping 
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }
    
    @PutMapping("/{userId}")
    public User updateUser(@RequestBody User user,@PathVariable int userId) {
		return	userService.saveUser(userId) ;
    	
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }
}

