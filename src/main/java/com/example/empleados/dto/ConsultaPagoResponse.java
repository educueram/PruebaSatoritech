package com.example.empleados.dto;

public class ConsultaPagoResponse {
	
	private int payment;
    private boolean success;
    
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

}
