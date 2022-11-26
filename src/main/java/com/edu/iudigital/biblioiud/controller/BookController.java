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

import com.edu.iudigital.biblioiud.models.Book;
import com.edu.iudigital.biblioiud.services.BookServices;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookServices bookServ;
	
	
	@PostMapping()
	public ResponseEntity<?> CreateBook(@RequestBody Book book) {
		return bookServ.createBook(book);
	};
	
	@GetMapping("{id}")
	public ResponseEntity<?> getBook( @PathVariable(name="id") Long  id){
		return bookServ.getBookById(id);
	}
	
	@GetMapping()
	public ResponseEntity<?> getAllBooks( ){
		return bookServ.getAllBooks();
	}
	
	@PutMapping()
	public ResponseEntity<?> updateBook(@RequestBody Book book ){
		return bookServ.updateBook(book);
	}
	
	@DeleteMapping()
	public ResponseEntity<?> deleteBook(@PathVariable Long id ){
		return bookServ.deleteBook(id);
	}
	
	
	
	

}
