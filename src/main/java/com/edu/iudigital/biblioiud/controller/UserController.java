package com.edu.iudigital.biblioiud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.edu.iudigital.biblioiud.models.User;
import com.edu.iudigital.biblioiud.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServices userService;
	
	@PostMapping()
	public ResponseEntity<?> Createuser(@RequestBody User user) {
		return userService.createUser(user);
	};
	
	@GetMapping()
	public ResponseEntity<?> geAllUser( ){
		return userService.getAllUser();
	}
	
	@PutMapping()
	public ResponseEntity<?> updateUser(@RequestBody User user ){
		return userService.updateUser(user);
	}
	
	@DeleteMapping()
	public ResponseEntity<?> deleteUser(@PathVariable Long id ){
		return userService.deleteUser(id);
	}

}
