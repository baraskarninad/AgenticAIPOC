package storerepo.hybris.core;

public class AddressValidator {
    private static final String FORBIDDEN_CHARACTERS = "!#$%^&*()_+=|`~[]{};:'\",<>?/"; // Removed '@'

    public static void validate(String address) {
        for (char forbidden : FORBIDDEN_CHARACTERS.toCharArray()) {
            if (address.indexOf(forbidden) != -1) {
                throw new IllegalArgumentException("Address contains unsupported special character '" + forbidden + "'");
            }
        }
        // Example: Additional validation logic can be here, kept intact.
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        if (address.length() > 100) {
            throw new IllegalArgumentException("Address is too long");
        }
        // Further business-specific validations can continue here.
        // e.g., verifying country codes, ZIP, etc.
    }
}
```
