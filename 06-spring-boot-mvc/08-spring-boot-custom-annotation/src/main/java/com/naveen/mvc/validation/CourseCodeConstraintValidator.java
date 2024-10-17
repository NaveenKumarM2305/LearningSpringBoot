package com.naveen.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {

    private String preFix;
    @Override
    public void initialize(CourseCode theCourseCode) {
       preFix=theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if(theCode!=null){
            result= theCode.startsWith(preFix);
        }
        else {
            result=true;
        }
        return result;
    }
}
