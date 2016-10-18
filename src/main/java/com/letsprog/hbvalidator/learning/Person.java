package com.letsprog.hbvalidator.learning;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class Person {
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Pattern(regexp="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+).([a-zA-Z]{2,3})$")
	private String emailAddress;
	
	@PositiveNumberConstraint
	private String age;

	public String getName() {
		return name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}