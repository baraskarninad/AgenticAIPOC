package hybris.core;

public class AddressValidator {

    // Example snippet for AddressValidator.java near line 47
    private static final String INVALID_ADDRESS_CHARS = "@"; // Add/remove as needed

    public void validate(String address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null.");
        }
        for (char c : INVALID_ADDRESS_CHARS.toCharArray()) {
            if (address.indexOf(c) >= 0) {
                throw new IllegalArgumentException("Address contains unsupported special character '" + c + "'. Please remove this character and try again.");
            }
        }
        // Continue with current validation logic
        // Example: check if address is empty
        if (address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty.");
        }
        // Other validation logic as required
    }
    // Optionally, customize INVALID_ADDRESS_CHARS or allow '@' if business logic requires.
}
