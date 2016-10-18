package com.letsprog.hbvalidator.learning;

import java.util.Arrays;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class DefaultProviderMain {

	public static void main(String[] args) {

		Person validPerson = new Person();

		validPerson.setName("Farah");
		validPerson.setAge("26");
		validPerson.setEmailAddress("farah.fertassi.dev@gmail.com");
		validPerson.setLuckyNumbers(Arrays.asList("0","2"));

		Person inValidPerson = new Person();

		inValidPerson.setName("Koko");
		inValidPerson.setAge("-18");
		inValidPerson.setEmailAddress("farah.fertassi.dev");
		inValidPerson.setLuckyNumbers(Arrays.asList("3","-4","45"));

		// In our pom.xml only Hibernate Validator is included. This makes it the default validator.
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Person>> validPersonConstraintViolations = validator.validate(validPerson);
		System.out.println("validPersonConstraintViolations.size : "+validPersonConstraintViolations.size());

		Set<ConstraintViolation<Person>> inValidPersonConstraintViolations = validator.validate(inValidPerson);
		System.out.println("inValidPersonConstraintViolations.size : "+inValidPersonConstraintViolations.size());
		System.out.println("Constraints Violations : "+inValidPersonConstraintViolations.toString());

	}

}
