package by.javaguru.profiler.usecasses.annotation;

import by.javaguru.profiler.usecasses.util.Sequencable;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.Objects;

public class SequenceNumbersValidator
        implements ConstraintValidator<SequenceNumbersValidation, List<? extends Sequencable>> {
    @Override
    public boolean isValid(List<? extends Sequencable> value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty() || value.contains(null)) {
            return true;
        }
        int valueSize = value.size();
        List<Integer> sequenceNumbers = value.stream()
                .map(Sequencable::sequenceNumber)
                .distinct()
                .filter(Objects::nonNull)
                .filter(n -> n <= valueSize)
                .toList();
        return valueSize == sequenceNumbers.size();
    }
}
