package com.edu.iudigital.biblioiud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.iudigital.biblioiud.models.Autor;
import com.edu.iudigital.biblioiud.services.AutorServices;


@RestController
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired
	AutorServices autorServices;
	
	
	@PostMapping()
	public ResponseEntity<?> CreateAutor(@RequestBody Autor autor) {
		return autorServices.createAutor(autor);
	};
	
	
	@GetMapping("{id}")
	public ResponseEntity<?> getAutor( @PathVariable(name="id") Long  id){
		return autorServices.getAutor(id);
	}
	
	@GetMapping()
	public ResponseEntity<?> getAllAutor( ){
		return autorServices.getAllAutor();
	}
	
	
	@PutMapping()
	public ResponseEntity<?> updateAutor(@RequestBody Autor aut){
		return autorServices.updateAutor(aut);
	}

}
