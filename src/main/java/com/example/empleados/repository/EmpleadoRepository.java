package com.example.empleados.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.empleados.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	
    Optional<Empleado> findByNameAndLastName(String name, String lastName);
    
}