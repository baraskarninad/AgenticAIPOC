package hybris.core;

public class AddressValidator {
    public ValidationResult validate(Address address) {
        if (address == null) {
            return ValidationResult.invalid("Address cannot be null");
        }
        String value = address.getValue();
        if (value == null) {
            return ValidationResult.invalid("Address value cannot be null");
        }
        if (value.contains("@")) {
            return ValidationResult.invalid("Address contains unsupported special character '@'");
        }
        // Add further special character checks as needed
        return ValidationResult.valid();
    }
}
