package storerepo.hybris.core;

public class AddressValidator {

    public void validate(String address) throws ValidationException {
        if (address == null || address.isEmpty()) {
            throw new ValidationException("Address cannot be null or empty.");
        }
        // Fix: Ensure the regex treats \s as a whitespace (not as an escape for 's')
        if (!address.matches("^[a-zA-Z0-9\\s,.'-]+$")) {
            throw new ValidationException("Address contains invalid characters. Allowed: letters, numbers, space, comma, dot, apostrophe, hyphen.");
        }
        // Other existing validation logic
        if (address.length() < 5) {
            throw new ValidationException("Address is too short.");
        }
        if (address.length() > 100) {
            throw new ValidationException("Address is too long.");
        }
        // Add more validations as needed
    }

    // Add other methods as required
}
