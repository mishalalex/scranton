package com.office.scranton.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordValidation, String> {

    @Override
    public boolean isValid(String inputPassword, ConstraintValidatorContext constraintValidatorContext) {
        String pattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[@!#$%^&*()_+=-]).{10,}$";
        return inputPassword.matches(pattern);
    }
}
