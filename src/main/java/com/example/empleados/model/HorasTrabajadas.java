package com.example.empleados.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class HorasTrabajadas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Empleado employee;

    private int worked_hours;
    private LocalDate worked_date;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Empleado getEmployee() {
		return employee;
	}
	public void setEmployee(Empleado employee) {
		this.employee = employee;
	}
	public int getWorked_hours() {
		return worked_hours;
	}
	public void setWorked_hours(int worked_hours) {
		this.worked_hours = worked_hours;
	}
	public LocalDate getWorked_date() {
		return worked_date;
	}
	public void setWorked_date(LocalDate worked_date) {
		this.worked_date = worked_date;
	}

    
}

