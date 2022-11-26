package com.edu.iudigital.biblioiud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edu.iudigital.biblioiud.models.Categorie;
import com.edu.iudigital.biblioiud.repository.ICategorieRepository;

@Service
public class CategoriesServices {

	@Autowired
	ICategorieRepository categorieRepository;
	
	
	public ResponseEntity<?> createCategorie(Categorie cat) {
		try {
			categorieRepository.save(cat);
			return new ResponseEntity<>(cat, HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Ha ocurrido un error "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public ResponseEntity<?> getAllCategories(){
		try {
			return new ResponseEntity<>(categorieRepository.findAll(), HttpStatus.OK);
			
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Ha ocurrido un error "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	public ResponseEntity<?> updateCategorie(Categorie cat) {
		try {
			categorieRepository.save(cat);
			return new ResponseEntity<>(cat, HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Ha ocurrido un error "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	public ResponseEntity<?> deleteCategorie(Long id) {
		try {
			categorieRepository.deleteById(id);
			return new ResponseEntity<>("Categoria eliminada", HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Ha ocurrido un error "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	
	
	
}
