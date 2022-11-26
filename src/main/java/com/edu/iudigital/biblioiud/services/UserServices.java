package com.edu.iudigital.biblioiud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.edu.iudigital.biblioiud.models.User;
import com.edu.iudigital.biblioiud.repository.IUserRepository;


@Service
public class UserServices {
	
	@Autowired
	IUserRepository userRepository;
	
	public ResponseEntity<?> createUser(User user) {
		try {
			user.setState(true);
			userRepository.save(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
			
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No fue posible crear el  usuario", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public ResponseEntity<?> updateUser(User user){
		try {
			 userRepository.save(user);
			 return new ResponseEntity<>(user,HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No fue posible actualizar el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> getAllUser(){
		try {
			 
			 return new ResponseEntity<>(userRepository.findAll(),HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No fue posible traer los  usuarios", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> deleteUser(Long id){
		try {
			 userRepository.deleteById(id);
			 return new ResponseEntity<>("Usuario eliminado",HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No fue posible eliminar el  usuario", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
