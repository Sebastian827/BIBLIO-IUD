package com.edu.iudigital.biblioiud.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="type_user")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TypeUser implements Serializable{
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	Long id;
	
	@Column(name="description", length = 30, nullable = false)
	String description;
	

}
