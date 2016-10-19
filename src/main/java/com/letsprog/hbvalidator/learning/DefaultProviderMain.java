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
		inValidPerson.setAge("-18");
		inValidPerson.setEmailAddress("farah.fertassi.dev");
		inValidPerson.setLuckyNumbers(Arrays.asList("3","-4","45"));
		inValidPerson.setCar(new Car(""));

		// In our pom.xml only Hibernate Validator is included. This makes it the default validator.
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Person>> validPersonConstraintViolations = validator.validate(validPerson);
		System.out.println("validPersonConstraintViolations.size : "+validPersonConstraintViolations.size());

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
