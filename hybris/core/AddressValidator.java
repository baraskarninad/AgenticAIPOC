// Example code snippet for AddressValidator.java
private static final String UNSUPPORTED_CHARACTERS = "#$%^&*()";

public boolean isValid(String address) {
    for (char c : UNSUPPORTED_CHARACTERS.toCharArray()) {
        if (address.indexOf(c) >= 0) {
            // Optionally add a user-friendly message here
            return false;
        }
    }
    return true;
}

// To relax validation:
// Remove '@' from UNSUPPORTED_CHARACTERS if business now permits it.
```
**Note:** Only '@' was removed from the UNSUPPORTED_CHARACTERS String. All other logic and formatting remain unchanged, as requested.