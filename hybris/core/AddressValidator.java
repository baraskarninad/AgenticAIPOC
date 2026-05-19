package hybris.core;

public class AddressValidator {

    private static final String ALLOWED_CHARS_REGEX = "^[a-zA-Z0-9\\s#,\\.\\-]*$";

    public void validate(String address) {
        if (!address.matches(ALLOWED_CHARS_REGEX)) {
            throw new IllegalArgumentException("Address contains unsupported special characters. Allowed characters are letters, numbers, spaces, #, ,, ., and -.");
        }

        // Original validation logic starts
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty.");
        }
        if (address.length() < 5) {
            throw new IllegalArgumentException("Address is too short. Please provide a valid address.");
        }
        if (address.length() > 100) {
            throw new IllegalArgumentException("Address is too long. Please limit to 100 characters.");
        }
        // Example of other checks
        if (!Character.isLetterOrDigit(address.charAt(0))) {
            throw new IllegalArgumentException("Address must start with a letter or number.");
        }
        // You may have additional checks here
        // Original validation logic ends
    }

    // Possibly other methods and logic
}
```
