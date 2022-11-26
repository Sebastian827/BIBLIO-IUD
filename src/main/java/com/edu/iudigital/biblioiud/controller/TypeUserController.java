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

import com.edu.iudigital.biblioiud.models.TypeUser;
import com.edu.iudigital.biblioiud.services.TypeUserServices;

@RestController
@RequestMapping("/typeUser")
public class TypeUserController {
	
	@Autowired
	TypeUserServices typeServ;
	
	@PostMapping()
	public ResponseEntity<?> CreateTypeUser(@RequestBody TypeUser type) {
		return typeServ.createTypeUser(type);
	};
	
	@GetMapping()
	public ResponseEntity<?> geAllTypeUser( ){
		return typeServ.getAllTypeUser();
	}
	
	@PutMapping()
	public ResponseEntity<?> updateTypeUser(@RequestBody TypeUser type ){
		return typeServ.updateTypeUser(type);
	}
	
	@DeleteMapping()
	public ResponseEntity<?> deleteTypeUser(@PathVariable Long id ){
		return typeServ.deleteTypeUser(id);
	}


}
