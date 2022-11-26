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

import com.edu.iudigital.biblioiud.models.Categorie;
import com.edu.iudigital.biblioiud.services.CategoriesServices;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
	
	@Autowired
	CategoriesServices categorieService;
	
	@PostMapping()
	public ResponseEntity<?> createCategorie(@RequestBody Categorie cat) {
		return categorieService.createCategorie(cat);
	}
	
	@GetMapping()
	public ResponseEntity<?> getAllCategories() {
		return categorieService.getAllCategories();
	}
	
	@PutMapping()
	public ResponseEntity<?> updateCategorie(@RequestBody Categorie cat) {
		return categorieService.updateCategorie(cat);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteCategorie(@PathVariable Long id) {
		return categorieService.deleteCategorie(id);
	}
	
	
	

}
