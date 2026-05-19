package hybris.core;

public class AddressValidator {

    // In your address validation routine:
    // Updated regex to allow '@' character as well
    private static final String UNSUPPORTED_CHAR_REGEX = "[^a-zA-Z0-9\\s#,.@]";

    public boolean validate(String address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        // Check for length
        if (address.length() < 5) {
            throw new IllegalArgumentException("Address too short");
        }
        // Check for unsupported characters
        if (address.matches(".*" + UNSUPPORTED_CHAR_REGEX + ".*")) {
            throw new IllegalArgumentException("Address contains unsupported special character.");
        }
        // If you need to allow '@', update regex or add:
        // UNSUPPORTED_CHAR_REGEX = "[^a-zA-Z0-9\s#,.@]";
        // Or log warning instead of throwing if business needs allow it
        return true;
    }
}
```
