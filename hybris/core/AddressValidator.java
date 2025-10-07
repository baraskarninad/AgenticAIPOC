package hybris.core;

import java.util.regex.Pattern;

public class AddressValidator {

    // Make allowed characters configurable via environment variable
    private static final String ALLOWED_ADDRESS_CHARS = System.getenv().getOrDefault("ALLOWED_ADDRESS_CHARS", "a-zA-Z0-9 .,'@-");
    private static final Pattern INVALID_CHARS_PATTERN = Pattern.compile("[^" + ALLOWED_ADDRESS_CHARS + "]");

    public void validate(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }

        if (INVALID_CHARS_PATTERN.matcher(address).find()) {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }

        // Additional validation logic (e.g., length checks, etc.)
        if (address.length() < 5) {
            throw new IllegalArgumentException("Address is too short");
        }
        if (address.length() > 255) {
            throw new IllegalArgumentException("Address is too long");
        }
    }

    // Other existing methods, if any

}
