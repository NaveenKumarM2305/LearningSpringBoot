package com.naveen.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
public @interface CourseCode {
    public String value() default "MCA";
    public String message()  default "Must start with MCA";


    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
