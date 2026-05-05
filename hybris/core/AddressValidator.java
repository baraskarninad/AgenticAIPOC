package storerepo.hybris.core;

public class AddressValidator {

    // Existing logic and fields, constructors, etc.

    // Example: Relax the allowed character set in AddressValidator
    private boolean isAllowedCharacter(char c) {
        // Old: return Character.isLetterOrDigit(c) || c == ' ' || c == ',' || c == '.' || c == '#';
        // New: Add '@' if desired
        return Character.isLetterOrDigit(c) || c == ' ' || c == ',' || c == '.' || c == '#' || c == '@';
    }

    // Also, improve error feedback
    private void validate(String address) {
        for (char c : address.toCharArray()) {
            if (!isAllowedCharacter(c)) {
                throw new IllegalArgumentException(
                    "Address contains unsupported special character '" + c + "'."
                );
            }
        }
    }

    // Other existing methods, logic, etc.
    public boolean validateAddress(String address) {
        // Call to validate method
        validate(address);
        // Additional validation logic
        // Return true if address is valid
        return true;
    }

    // Additional methods and logic as originally existing
}
```
