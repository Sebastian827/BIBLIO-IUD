package com.edu.iudigital.biblioiud.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="books")
public class Book implements Serializable{
	


	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	Long id;
	
	@Column(length = 50,nullable = false)
	String title;
	
	@Column(length = 50,nullable = false)
	String isbn;
	
	@Column(nullable = false)
	Long numberPage;
	
	@Column(length = 50,nullable = false)
	String editorial;
	
	@Column(length = 50,nullable = false)
	String format;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="autores_books",
	joinColumns = {@JoinColumn(name="books_id")},
	inverseJoinColumns = {@JoinColumn(name="autores_id")})
	List<Autor> autores;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="categories_books",
	joinColumns = {@JoinColumn(name="books_id")},
	inverseJoinColumns = {@JoinColumn(name="categories_id")})
	List<Categorie> categories;
	
}
