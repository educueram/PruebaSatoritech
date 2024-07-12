package com.example.empleados.dto;

import java.time.LocalDate;

public class EmpleadoDTO {
	
	private Long id;
    private String name;
    private String last_name;
    private LocalDate birthdate;
    private PuestoDTO job;
    private GeneroDTO gender;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	public PuestoDTO getJob() {
		return job;
	}
	public void setJob(PuestoDTO job) {
		this.job = job;
	}
	public GeneroDTO getGender() {
		return gender;
	}
	public void setGender(GeneroDTO gender) {
		this.gender = gender;
	}

}
