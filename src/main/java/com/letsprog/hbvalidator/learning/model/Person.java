package com.letsprog.hbvalidator.learning.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.letsprog.hbvalidator.learning.validator.PositiveNumberConstraint;
import com.letsprog.hbvalidator.learning.validator.Severity;

public class Person {
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Pattern(regexp="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+).([a-zA-Z]{2,3})$")
	private String emailAddress;
	
	@NotNull
	@PositiveNumberConstraint(payload=Severity.Error.class) // Customized Constraint Annotation
	private String age;
	
//	@Valid
//	private List<@PositiveNumberConstraint String> luckyNumbers;
	private List<String> luckyNumbers;
	
	@NotNull
	@Valid Car car;

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

	public List<String> getLuckyNumbers() {
		return luckyNumbers;
	}

	public void setLuckyNumbers(List<String> luckyNumbers) {
		this.luckyNumbers = luckyNumbers;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
}