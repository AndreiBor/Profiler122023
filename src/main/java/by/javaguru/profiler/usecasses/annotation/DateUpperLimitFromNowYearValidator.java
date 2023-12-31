package by.javaguru.profiler.usecasses.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;

public class DateUpperLimitFromNowYearValidator implements ConstraintValidator<DateUpperLimitFromNowValidation, Year> {

    private long increment;

    @Override
    public void initialize(DateUpperLimitFromNowValidation constraintAnnotation) {
        this.increment = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Year value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        Year maxYear = Year.now().plusYears(increment);
        return value.isBefore(maxYear) || value.equals(maxYear);
    }

}
