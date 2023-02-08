package com.example.collateralmanagement.models.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ExistingClientValidator.class)
public @interface ExistingClient {

    String message() default "Client is not in the database.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}