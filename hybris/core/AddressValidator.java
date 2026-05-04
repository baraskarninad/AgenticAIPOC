package hybris.core;

public class AddressValidator {

    // Example: Update allowed characters set in AddressValidator.java
    private static final String ALLOWED_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 .,#@";

    public boolean validate(String address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }

        // Validate allowed characters in the address string
        for (char c : address.toCharArray()) {
            if (ALLOWED_CHARS.indexOf(c) < 0) {
                throw new IllegalArgumentException("Address contains unsupported special character '" + c + "'");
            }
        }

        // Additional validation rules (existing logic)
        if (address.length() < 5) {
            throw new IllegalArgumentException("Address is too short");
        }
        if (address.length() > 100) {
            throw new IllegalArgumentException("Address is too long");
        }
        // Other checks can stay here as they were
        // If all checks pass, return true
        return true;
    }
}
