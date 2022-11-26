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


import com.edu.iudigital.biblioiud.models.Ejemplar;
import com.edu.iudigital.biblioiud.services.EjemplarServices;

@RestController
@RequestMapping("/ejemplar")
public class EjemplarController {
	
	@Autowired
	EjemplarServices ejemService;
	
	@PostMapping()
	public ResponseEntity<?> CreateEjemplar(@RequestBody Ejemplar ejm) {
		return ejemService.createEjemplar(ejm);
	};
	
	@GetMapping()
	public ResponseEntity<?> getAllEjemplares( ){
		return ejemService.getAllEjemplar();
	}
	
	@PutMapping()
	public ResponseEntity<?> updateBook(@RequestBody Ejemplar ejm ){
		return ejemService.updateEjemplar(ejm);
	}
	
	@DeleteMapping()
	public ResponseEntity<?> deleteBook(@PathVariable Long id ){
		return ejemService.deleteEjemplar(id);
	}

}
