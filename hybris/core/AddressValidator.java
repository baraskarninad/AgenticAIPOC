package storerepo.hybris.core;

public class AddressValidator {

    // Remove '@' from UNSUPPORTED_CHARACTERS as per new requirements
    private static final String UNSUPPORTED_CHARACTERS = "";

    public void validate(String address) {
        for (char c : UNSUPPORTED_CHARACTERS.toCharArray()) {
            if (address.indexOf(c) >= 0) {
                throw new IllegalArgumentException("Address contains unsupported special character '" + c + "'. Please remove it from your address.");
            }
        }

        // Existing validation logic
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address must not be empty.");
        }
        
        if (address.length() < 5) {
            throw new IllegalArgumentException("Address is too short.");
        }

        // Check for only whitespace or special characters
        if (!address.matches(".*[a-zA-Z0-9].*")) {
            throw new IllegalArgumentException("Address must contain at least one alphanumeric character.");
        }
        
        // Example: forbid P.O. Boxes
        if (address.toLowerCase().contains("p.o. box") || address.toLowerCase().contains("po box")) {
            throw new IllegalArgumentException("P.O. Boxes are not allowed as delivery addresses.");
        }

        // Further domain-specific validations can be added here
    }
}
```
**Explanation of Change:**  
Only the definition of `UNSUPPORTED_CHARACTERS` has been changed from `"@"` to `""` as required; the rest of the class remains untouched. All original logic is preserved.