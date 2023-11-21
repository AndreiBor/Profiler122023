package by.javaguru.profiler.usecasses.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.hibernate.validator.constraints.UUID;

import java.lang.annotation.*;

@UUID(allowNil = false, message = UserImageValidation.IMAGE_UUID_IS_NOT_VALID)
@Documented
@Constraint(validatedBy = UserImageValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserImageValidation {

    String IMAGE_UUID_IS_NOT_VALID = "Image UUID is not valid!";

    String message() default IMAGE_UUID_IS_NOT_VALID;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    ValidatedDto toValidate();

    enum ValidatedDto {
        PROFILE_DTO,
        CV_DTO
    }
}
