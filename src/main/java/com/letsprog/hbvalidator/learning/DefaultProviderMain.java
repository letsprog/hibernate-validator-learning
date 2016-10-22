package com.letsprog.hbvalidator.learning;

import java.util.Arrays;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.letsprog.hbvalidator.learning.model.Car;
import com.letsprog.hbvalidator.learning.model.Person;
import com.letsprog.hbvalidator.learning.validator.Severity;

public class DefaultProviderMain {

	public static void main(String[] args) {

		Person validPerson = new Person();

		validPerson.setName("Farah");
		validPerson.setAge("26");
		validPerson.setEmailAddress("farah.fertassi@letsprog.com");
		validPerson.setLuckyNumbers(Arrays.asList("0","2"));
		validPerson.setCar(new Car("BMW"));

		Person inValidPerson = new Person();

		inValidPerson.setName("Koko");
		inValidPerson.setAge("-18"); // Constraint Violation 1 : Negative Number.
		inValidPerson.setEmailAddress("farah.fertassi.dev"); // Constraint Violation 2 : Email address pattern not respected.
		inValidPerson.setLuckyNumbers(Arrays.asList("3","-4","45")); // Constraint Violation 2 : One of the List's strings is a negative number.
		inValidPerson.setCar(new Car("")); // Constraint Violation 3 : The constructed will initialize car.brand by an empty string.

		// In our pom.xml only Hibernate Validator is included. This makes it the default validator.
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		// Being a valid person, this Set should be empty.
		Set<ConstraintViolation<Person>> validPersonConstraintViolations = validator.validate(validPerson);
		System.out.println("validPersonConstraintViolations.size : "+validPersonConstraintViolations.size());

		// This set should have 4 Constraint Violations.
		Set<ConstraintViolation<Person>> inValidPersonConstraintViolations = validator.validate(inValidPerson);
		
		
		for (ConstraintViolation<Person> report : inValidPersonConstraintViolations){

			System.out.println("report.getConstraintDescriptor().getPayload().size() : "+report.getConstraintDescriptor().getPayload().size());

			Boolean isError = false;
			if(report.getConstraintDescriptor().getPayload().iterator().hasNext())
				isError = Severity.Error.class.equals(report.getConstraintDescriptor().getPayload().iterator().next());
			System.out.println("isError : "+isError);
		}

		System.out.println("inValidPersonConstraintViolations.size : "+inValidPersonConstraintViolations.size());
		System.out.println("Constraints Violations : "+inValidPersonConstraintViolations.toString());

	}

}
