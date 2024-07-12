package com.example.empleados.repository;

import com.example.empleados.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
	
    Optional<Genero> findById(Long id);
    
}