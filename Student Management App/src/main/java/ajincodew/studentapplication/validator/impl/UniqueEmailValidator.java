package ajincodew.studentapplication.validator.impl;

import ajincodew.studentapplication.repository.StudentRepository;
import ajincodew.studentapplication.validator.UniqueEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final StudentRepository studentRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.trim().isEmpty()) {
            return true; // @NotBlank will handle null/empty cases
        }
        return !studentRepository.existsByEmail(email);
    }
}