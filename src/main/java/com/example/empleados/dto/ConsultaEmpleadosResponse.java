package com.example.empleados.dto;

import java.util.List;

public class ConsultaEmpleadosResponse {

	private List<EmpleadoDTO> employees;
    private boolean success;
    
	public List<EmpleadoDTO> getEmployees() {
		return employees;
	}
	public void setEmployees(List<EmpleadoDTO> employees) {
		this.employees = employees;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
    
}
