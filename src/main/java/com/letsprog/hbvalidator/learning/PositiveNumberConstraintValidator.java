package com.letsprog.hbvalidator.learning;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PositiveNumberConstraintValidator implements ConstraintValidator<PositiveNumberConstraint,String>{

	@Override
	public void initialize(PositiveNumberConstraint constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		boolean isPostive = false;
		
		if(Integer.parseInt(value)>=0){
			isPostive = true;
		}
		
		return isPostive;
	}

}
