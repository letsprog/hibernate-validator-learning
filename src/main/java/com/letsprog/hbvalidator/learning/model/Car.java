package com.letsprog.hbvalidator.learning.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Car {
	
	@NotEmpty
	private String brand;
	
	public Car(){}
	
	public Car(String brand){
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	
}