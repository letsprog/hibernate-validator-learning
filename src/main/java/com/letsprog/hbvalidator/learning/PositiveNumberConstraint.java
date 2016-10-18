package com.letsprog.hbvalidator.learning;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PositiveNumberConstraintValidator.class)
@Documented
public @interface PositiveNumberConstraint {
	
	String message() default "This field must be positive";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {}; // TODO FFE Check what this is for.

}
