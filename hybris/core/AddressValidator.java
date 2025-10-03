// In hybris/core/AddressValidator.java

public class AddressValidator {

    public void validate(String address) {
        // Existing character validation regex
        if (!address.matches("^[A-Za-z0-9 #,\\-]+$")) { // Example regex
            String invalidChars = address.replaceAll("[A-Za-z0-9 #,\\-]", "");
            throw new IllegalArgumentException("Address contains invalid characters: '" + invalidChars + "'");
        }
        // ... rest of validation
    }

    // To provide user-friendly messaging:
    public void validateWithMessage(String address) {
        String invalidChars = address.replaceAll("[A-Za-z0-9 #,\\-]", "");
        if (!invalidChars.isEmpty()) {
            throw new IllegalArgumentException("Address contains invalid characters: '" + invalidChars + "'");
        }
        // ... rest of validation
    }

}
```
