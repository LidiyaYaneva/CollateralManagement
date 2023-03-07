package com.example.collateralmanagement.models.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ExistingAssetValidator.class)
public @interface ExistingAsset {

    String message() default "Asset is not in the database.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
