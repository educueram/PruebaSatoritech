package com.example.empleados.dto;

public class ConsultaHorasTrabajadasResponse {
	
	private int total_worked_hours;
    private boolean success;
    
	public int getTotal_worked_hours() {
		return total_worked_hours;
	}
	public void setTotal_worked_hours(int total_worked_hours) {
		this.total_worked_hours = total_worked_hours;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

}
