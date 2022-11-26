package com.edu.iudigital.biblioiud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.edu.iudigital.biblioiud.models.Ejemplar;
import com.edu.iudigital.biblioiud.repository.IEjemplarRepository;

@Service
public class EjemplarServices {
	
	@Autowired
	IEjemplarRepository ejempRepo;
	
	
	public ResponseEntity<?> createEjemplar(Ejemplar ej){
		try {
			ej.setState(true);
			 ejempRepo.save(ej);
			 return new ResponseEntity<>(ej,HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No fue posible crear el ejemplar", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> updateEjemplar(Ejemplar ej){
		try {
			 ejempRepo.save(ej);
			 return new ResponseEntity<>(ej,HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No fue posible actualizar el ejemplar", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> getAllEjemplar(){
		try {
			 
			 return new ResponseEntity<>(ejempRepo.findAll(),HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No fue posible traer los ejemplares", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> deleteEjemplar(Long id){
		try {
			 ejempRepo.deleteById(id);
			 return new ResponseEntity<>("Ejemplar eliminado",HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No fue posible eliminar el ejemplar", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
