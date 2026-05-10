package hybris.core;

public class AddressValidator {
    // In hybris.core.AddressValidator.java
    private static final String UNSUPPORTED_CHARS = "#$%&*"; // '@' removed to relax validation

    public boolean validateAddress(String address) {
        for (char c : UNSUPPORTED_CHARS.toCharArray()) {
            if (address.contains(String.valueOf(c))) {
                // Optionally, log the error, provide user guidance, or relax validation if needed
                throw new IllegalArgumentException("Address contains unsupported special character '" + c + "'");
            }
        }
        // proceed with rest of validation
        return true;
    }

    // To relax validation, either remove '@' from UNSUPPORTED_CHARS or allow configuration at runtime
}
```
