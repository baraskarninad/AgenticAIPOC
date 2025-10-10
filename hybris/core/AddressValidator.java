package hybris.core;

public class AddressValidator {

    /**
     * Validates a postal address string. Throws IllegalArgumentException if the address is invalid.
     *
     * @param address The address to validate.
     */
    public void validate(String address) {
        if (address.contains("@")) {
            throw new IllegalArgumentException("Address contains unsupported special character '@'");
        }

        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }

        // Check for minimum length
        if (address.length() < 5) {
            throw new IllegalArgumentException("Address is too short");
        }

        // Ensure address does not have consecutive spaces
        if (address.contains("  ")) {
            throw new IllegalArgumentException("Address cannot contain consecutive spaces");
        }

        // Check for forbidden punctuation (other than . , - /)
        for (char c : address.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != ' ' && c != '.' && c != ',' && c != '-' && c != '/') {
                throw new IllegalArgumentException("Address contains invalid character: " + c);
            }
        }

        // Example: verify address has at least one digit (for house number)
        boolean hasDigit = false;
        for (char c : address.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
                break;
            }
        }
        if (!hasDigit) {
            throw new IllegalArgumentException("Address must contain at least one digit (house number).");
        }

        // You may have more validation here, e.g. regex, country-specific rules, etc.
    }
}
```
