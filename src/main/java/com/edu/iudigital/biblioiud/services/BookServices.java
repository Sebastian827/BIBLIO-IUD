package com.edu.iudigital.biblioiud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.edu.iudigital.biblioiud.models.Book;
import com.edu.iudigital.biblioiud.repository.IBookRepository;

@Service
public class BookServices {
	
	@Autowired
	IBookRepository bookRepo;
	
	public ResponseEntity<?> createBook(Book book){
		try {
			 bookRepo.save(book);
			 return new ResponseEntity<>(book,HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No fue posible crear el libro", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> getAllBooks(){
		try {
			return new ResponseEntity<>(bookRepo.findAll(),HttpStatus.OK);
			
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Ha ocurrido un error al listar libros "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	public ResponseEntity<?> getBookById(Long id){
		try {
			return new ResponseEntity<>(bookRepo.findById(id),HttpStatus.OK);
			
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Ha ocurrido un error al buscar el libro "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> updateBook( Book book){
		try {
			bookRepo.save(book);
			return new  ResponseEntity<>(book,HttpStatus.OK);
			
		}catch (Exception e) {
			// TODO: handle exception
			return new  ResponseEntity<>("Ha ocurrido un error "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> deleteBook(Long id){
		try {
			bookRepo.deleteById(id);
			return new  ResponseEntity<>("Eliminado correctamente", HttpStatus.OK);
			
		}catch (Exception e) {
			// TODO: handle exception
			return new  ResponseEntity<>("Ha ocurrido un error "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
