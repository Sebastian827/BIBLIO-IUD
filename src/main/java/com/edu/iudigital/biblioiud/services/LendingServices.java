package com.edu.iudigital.biblioiud.services;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edu.iudigital.biblioiud.models.Ejemplar;
import com.edu.iudigital.biblioiud.models.Lending;
import com.edu.iudigital.biblioiud.models.User;
import com.edu.iudigital.biblioiud.repository.IEjemplarRepository;
import com.edu.iudigital.biblioiud.repository.ILendingRepository;
import com.edu.iudigital.biblioiud.repository.ITypeUserRepository;
import com.edu.iudigital.biblioiud.repository.IUserRepository;

@Service
public class LendingServices {
	
	@Autowired
	ILendingRepository lendingRepo;
	
	@Autowired
	IUserRepository userRepo;
	
	@Autowired
	ITypeUserRepository typeRepo;
	
	@Autowired
	IEjemplarRepository ejemRepo;
	
	
	public ResponseEntity<?> createLending(Lending len){
		try {
			User us = userRepo.findById(len.getUser().getId()).get();
			
			
			if(!us.getState()) {
				return new ResponseEntity<>("El usuario no tiene permitido solicitar libros",HttpStatus.OK);	
			}
			if(!CanUserGetLending(us, us.getType().getId())) {
				return new ResponseEntity<>("El usuario excedio el numero de libros permitidos a solicitar",HttpStatus.OK);
			}
			if(!BookAvalaible(len)) {
				return new ResponseEntity<>("Hay ejemplares no disponibles en su pedido de prestamo",HttpStatus.OK);
			}
			len.setCheckIn(LocalDateTime.now());
			len.setState(true);
			lendingRepo.save(len);
			ChangeBookStatus(len, 0);
			 return new ResponseEntity<>(len,HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No fue posible crear el prestamo "+ e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> updateLending(Long id){
		try {
			Lending len = lendingRepo.findById(id).get();
			len.setCheckOut(LocalDateTime.now());
			len.setState(false);
			
			Long n =ChronoUnit.DAYS.between(len.getCheckOut(), len.getCheckIn());
			
			if(n>8) {
				User us = userRepo.findById(len.getUser().getId()).get();
				us.setState(false);
				us.setTimeBan(LocalDateTime.now());
			}
			 lendingRepo.save(len);
			 ChangeBookStatus(len, 1);
			 
			 return new ResponseEntity<>(len,HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No fue posible actualizar el ejemplar", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> getAllLending(){
		try {
			 
			 return new ResponseEntity<>(lendingRepo.findAll(),HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No fue posible traer los prestamos", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> deleteLending(Long id){
		try {
			 lendingRepo.deleteById(id);
			 return new ResponseEntity<>("Ejemplar eliminado",HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No fue posible eliminar el prestamo", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public Boolean CanUserGetLending(User us, Long type){
		int r =0;
		List<Lending> n = lendingRepo.findAll();
		for(Lending i:n) {
			if(i.getState() && i.getUser().getId()==us.getId()) {
				r=r+i.getEjemplares().size();
				
				Long k =ChronoUnit.DAYS.between(LocalDateTime.now(), i.getCheckIn());
				if(k>=8) {
					return false;
				}
			}
			
			
		}
		if(type==1 && r>=5) {
			return false;
		}
		
		
		return true;
			
	
	}
	
	public Boolean BookAvalaible(Lending len) {
		List<Ejemplar> ejm = len.getEjemplares();
		for(Ejemplar i:ejm) {
			Ejemplar ej= ejemRepo.findById(i.getId()).get();
			if(!ej.getState()) {
				return false;
			}
			
		}
		
		
		return true;
	}
	
	public void ChangeBookStatus(Lending len, int type) {
		List<Ejemplar> ejm = len.getEjemplares();
		for(Ejemplar i:ejm) {
			Ejemplar ej= ejemRepo.findById(i.getId()).get();
			if(type==0) {
				ej.setState(false);
			}else {
				ej.setState(true);
			}
			
			ejemRepo.save(ej);
			
		}
	}

}
