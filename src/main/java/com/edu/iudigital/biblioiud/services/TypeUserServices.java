package com.edu.iudigital.biblioiud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.edu.iudigital.biblioiud.models.TypeUser;
import com.edu.iudigital.biblioiud.repository.ITypeUserRepository;

@Service
public class TypeUserServices {
	
	@Autowired
	ITypeUserRepository typeRepo;
	
	public ResponseEntity<?> createTypeUser(TypeUser type){
		try {
			typeRepo.save(type);
			 return new ResponseEntity<>(type,HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No fue posible crear el tipo de usuario", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> updateTypeUser(TypeUser type){
		try {
			 typeRepo.save(type);
			 return new ResponseEntity<>(type,HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No fue posible actualizar el tipo de usuario", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> getAllTypeUser(){
		try {
			 
			 return new ResponseEntity<>(typeRepo.findAll(),HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No fue posible traer los tipos de usuarios", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> deleteTypeUser(Long id){
		try {
			 typeRepo.deleteById(id);
			 return new ResponseEntity<>("Tipo de usuario eliminado",HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No fue posible eliminar el tipo de usuario", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
