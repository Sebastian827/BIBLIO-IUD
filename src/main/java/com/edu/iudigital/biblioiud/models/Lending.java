package com.edu.iudigital.biblioiud.models;

import java.io.Serializable;
import java.time.LocalDateTime;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="lendings")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lending implements Serializable {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	Long id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	User user;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="ejemplares_lending",
	joinColumns = {@JoinColumn(name="lendings_id")},
	inverseJoinColumns = {@JoinColumn(name="ejemplares_id")})
	List<Ejemplar> ejemplares;
	
	
	
	String observation;
	
	
	Boolean state;
	
	@Column(name = "check_in")
	private LocalDateTime checkIn;
	
	@Column(name = "check_out")
	private LocalDateTime checkOut;
	
	

}
