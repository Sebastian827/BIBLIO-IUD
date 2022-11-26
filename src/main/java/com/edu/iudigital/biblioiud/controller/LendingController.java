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

import com.edu.iudigital.biblioiud.models.Lending;
import com.edu.iudigital.biblioiud.services.LendingServices;

@RestController
@RequestMapping("/lending")
public class LendingController {
	
	@Autowired
	LendingServices lendingServ;
	
	@PostMapping()
	public ResponseEntity<?> CreateLending(@RequestBody Lending len) {
		return lendingServ.createLending(len);
	};
	
	@GetMapping()
	public ResponseEntity<?> getAllLendings( ){
		return lendingServ.getAllLending();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> CloseLending(@PathVariable Long id ){
		return lendingServ.updateLending(id);
	}
	
	@DeleteMapping()
	public ResponseEntity<?> deleteLending(@PathVariable Long id ){
		return lendingServ.deleteLending(id);
	}

}
