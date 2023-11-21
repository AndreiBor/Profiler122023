package by.javaguru.profiler.usecasses.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IsCvExistsValidator.class)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsCvExists {

    String message() default "Invalid uuid: curriculum vitae not found";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
