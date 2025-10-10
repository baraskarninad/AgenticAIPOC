package storerepo.hybris.core;

public class AddressValidator {

    public void validate(String input) throws ValidationException {
        if (input == null || input.isEmpty()) {
            throw new ValidationException("Address cannot be null or empty.");
        }
        // Fixed regex: in Java regex, \s inside a double-quoted string must be written as \\s
        if (!input.matches("^[a-zA-Z0-9\\s,.-]+$") ) {
            throw new ValidationException("Address contains invalid characters. Only letters, digits, spaces, commas, periods, and hyphens are allowed.");
        }
        // ... any other validation logic
    }

    // Other methods and logic, if there are any

    public static class ValidationException extends Exception {
        public ValidationException(String message) {
            super(message);
        }
    }
}
```
