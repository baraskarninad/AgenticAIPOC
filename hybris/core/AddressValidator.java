package hybris.core;

public class AddressValidator {

    // Example fix: Allow '@' if required 
    private static final String UNSUPPORTED_CHARS_REGEX = "[^a-zA-Z0-9\\s#,.@-]";  // '@' allowed

    public void validate(String address) {
        if (address.matches(UNSUPPORTED_CHARS_REGEX)) {
            throw new IllegalArgumentException("Address contains unsupported special character(s)");
        }
        // Add further address validation logic as required
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address must not be empty");
        }
        if (address.length() > 255) {
            throw new IllegalArgumentException("Address must not exceed 255 characters");
        }
        // Example: No consecutive special symbols allowed
        if (address.matches(".*([#,.@-])\\1+.*")) {
            throw new IllegalArgumentException("Address contains consecutive special characters");
        }
        // Example: Address must start with a letter or number
        if (!address.matches("^[a-zA-Z0-9].*")) {
            throw new IllegalArgumentException("Address must start with a letter or number");
        }
        // More validation logic as needed
    }
}
