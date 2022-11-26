package com.edu.iudigital.biblioiud.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="ejemplares")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ejemplar implements Serializable {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	Long id;
	
	String editionNumber;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="book_id")
	Book book;
	
	Boolean state;
	

}
