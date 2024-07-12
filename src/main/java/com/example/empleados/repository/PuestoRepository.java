package com.example.empleados.repository;

import com.example.empleados.model.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PuestoRepository extends JpaRepository<Puesto, Long> {
	
    Optional<Puesto> findById(Long id);
    
}
