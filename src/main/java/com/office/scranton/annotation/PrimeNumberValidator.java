package com.office.scranton.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumberValidation, Integer> {

    @Override
    public boolean isValid(Integer inputNumber, ConstraintValidatorContext constraintValidatorContext) {
        if(inputNumber <= 1) return false;
        if(inputNumber == 2) return true;
        if(inputNumber % 2 == 0) return false;
        for(int i = 3; i * i <= inputNumber; i+=2) {
            if(inputNumber % i == 0) return false;
        }
        return true;
    }
}
