package com.educandoweb.course.entities.enums;

public enum OrderStatus {

	// ENUM atribuído para cada status
	WATING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	// construtor 
	private OrderStatus(int code) {
		this.code = code;
	}
	
	// deixar o método acessível para o exterior
	public int getCode( ) {
		return code;
	}
	
	// método estático para converter o valor numérico para o tipo enumerado
	
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value: OrderStatus.values()) {
			if (value.getCode() == code) {
			return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus");
	
	}
}
