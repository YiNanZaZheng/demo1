package com.example.demo1.sys.annotation.validtion;

import com.example.demo1.sys.annotation.Region;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;

public class RegionValidator implements ConstraintValidator<Region,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        HashSet<Object> region = new HashSet<>();
        region.add("China");
        region.add("China-Taiwan");
        region.add("China-HongKong");
        return region.contains(value);
    }
}
