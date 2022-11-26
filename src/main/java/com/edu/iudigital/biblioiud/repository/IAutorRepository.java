package com.edu.iudigital.biblioiud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.iudigital.biblioiud.models.Autor;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Long> {

}
