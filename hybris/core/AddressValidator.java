package hybris.core;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AddressValidator implements ConstraintValidator<AddressConstraint, String> {

    @Override
    public void initialize(AddressConstraint constraintAnnotation) {
        // initialization logic if needed
    }

    @Override
    public boolean isValid(String addressField, ConstraintValidatorContext context) {
        // Allow only letters, numbers, spaces, and basic punctuation
        String pattern = "^[\\w\\s.,'-]*$";
        if (addressField == null || !addressField.matches(pattern)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Address contains invalid characters.")
                   .addConstraintViolation();
            return false;
        }
        // Existing logic continues here
        /*
         * Keep all existing validation logic below this point,
         * for example, checks for minimum or maximum length,
         * or other business rules.
         */
        if (addressField != null && addressField.trim().isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Address must not be empty.")
                   .addConstraintViolation();
            return false;
        }
        // Example of a length check
        if (addressField != null && addressField.length() > 200) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Address is too long.")
                   .addConstraintViolation();
            return false;
        }
        // Any other pre-existing checks or rules remain unchanged

        return true;
    }
}
