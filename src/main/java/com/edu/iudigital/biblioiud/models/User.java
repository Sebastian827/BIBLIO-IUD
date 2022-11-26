package com.edu.iudigital.biblioiud.models;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table(name="users")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	Long id;
	
	@Column(name="name", length = 30, nullable = false)
	String name;
	
	@Column(name="password", nullable = false)
	String password;
	
	@Column(name="address", length = 30, nullable = false)
	String address;
	
	@Column(name="number", length = 10, nullable = false)
	String number;
	
	@Column(name="nickname", length = 15, nullable = false)
	String nickname;
	
	@Column(name="email", nullable = false)
	String email;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="typeUser_id")
	TypeUser type;
	
	Boolean state;
	
	LocalDateTime timeBan;
	
	
	
}
