package com.letsprog.hbvalidator.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;

public class HibernateProviderMain {

	public static void main(String[] args) {

		Person validPerson = new Person();

		validPerson.setName("Farah");
		validPerson.setAge("26");
		validPerson.setEmailAddress("farah.fertassi.dev@gmail.com");
		validPerson.setLuckyNumbers(Arrays.asList("0","2"));
		validPerson.setCar(new Car("BMW"));

		Person inValidPerson = new Person();

		inValidPerson.setName("Koko");
		inValidPerson.setAge("-18");
		inValidPerson.setEmailAddress("farah.fertassi.dev");
		inValidPerson.setLuckyNumbers(Arrays.asList("3","-4","45"));
		inValidPerson.setCar(new Car(""));

		// If multiple Validation Providers exist, specify the one to use
		HibernateValidatorConfiguration validatorConfiguration = Validation.byProvider(HibernateValidator.class).configure();
		ValidatorFactory validatorFactory = validatorConfiguration.buildValidatorFactory();
		Validator validator = validatorFactory.getValidator();


		Set<ConstraintViolation<Person>> validPersonConstraintViolations = validator.validate(validPerson);
		System.out.println("validPersonConstraintViolations.size : "+validPersonConstraintViolations.size());

		Set<ConstraintViolation<Person>> inValidPersonConstraintViolations = validator.validate(inValidPerson);
		System.out.println("inValidPersonConstraintViolations.size : "+inValidPersonConstraintViolations.size());
		System.out.println("Constraints Violations : "+inValidPersonConstraintViolations.toString());

	}

}
