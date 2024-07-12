package com.example.empleados.repository;

import com.example.empleados.model.HorasTrabajadas;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

public interface HorasTrabajadasRepository extends JpaRepository<HorasTrabajadas, Long> {
	
    Optional<HorasTrabajadas> findByEmployeeIdAndWorkedDate(Long employeeId, LocalDate workedDate);
    List<HorasTrabajadas> findByEmployeeIdAndWorkedDateBetween(Long employeeId, LocalDate startDate, LocalDate endDate);
    
}