package com.edu.iudigital.biblioiud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.edu.iudigital.biblioiud.models.Autor;
import com.edu.iudigital.biblioiud.repository.IAutorRepository;

@Service
public class AutorServices {
	@Autowired
	IAutorRepository autorReporiAutorRepository;
	
	public ResponseEntity<?> createAutor(Autor autor) {
		try {
			autorReporiAutorRepository.save(autor);
			return new ResponseEntity<>(autor,HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No fue posible crear el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> getAutor(Long id){
		try {
			Autor a =autorReporiAutorRepository.findById(id).get();
		
			return new ResponseEntity<>(a,HttpStatus.OK);
		
	}catch(Exception e){
		return new ResponseEntity<>("No fue posible encontrar al usuario", HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
	}
	
	public ResponseEntity<?> getAllAutor(){
		try {
			return new ResponseEntity<>(autorReporiAutorRepository.findAll(),HttpStatus.OK);
		
	}catch(Exception e){
		return new ResponseEntity<>("No fue posible encontrar los autores", HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
	}
	
	
	
	public ResponseEntity<?> updateAutor(Autor autor){
		try {
			autorReporiAutorRepository.save(autor);
			return new ResponseEntity<>(autor,HttpStatus.OK);
			
		}catch (Exception e) {
			// TODO: handle exception
			return new  ResponseEntity<>("Ha ocurrido un error "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	

}
