package hybris.core;

public class AddressValidator {

    // Existing fields and methods...

    // At line 47 or the relevant line where address is checked:
    private static final String INVALID_CHAR_PATTERN = "[^a-zA-Z0-9\\s,#@.-]"; // add '@' if allowed

    public static void validateAddress(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }

        // Character validation logic (modified as requested)
        if (address.matches(".*" + INVALID_CHAR_PATTERN + ".*")) {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }

        // Other existing validation logic...
        if (address.length() < 5) {
            throw new IllegalArgumentException("Address is too short");
        }
        if (address.length() > 100) {
            throw new IllegalArgumentException("Address is too long");
        }
        // Any other existing checks...
    }

    // Other methods and logic...
}
```
**Note:**  
- The `INVALID_CHAR_PATTERN` now allows `@` as a valid character.
- The `matches` method is used with `".*" + INVALID_CHAR_PATTERN + ".*"` to check if any invalid character exists in the address string (since `matches` must match the entire string).
- All original logic is preserved; only the character validation is updated as requested.