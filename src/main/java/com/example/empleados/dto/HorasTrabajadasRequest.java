package com.example.empleados.dto;

import java.time.LocalDate;

public class HorasTrabajadasRequest {
	
	private Long employee_id;
    private int worked_hours;
    private LocalDate worked_date;
    
	public Long getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
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
