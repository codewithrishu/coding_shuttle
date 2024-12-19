package com.example.springbootMVCWeek2.springbootMVCWeek2.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null) return false;
       List<String> role = List.of("USER","ADMIN");
       return role.contains(value);
    }
}
