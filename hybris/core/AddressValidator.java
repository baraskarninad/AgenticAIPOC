// AddressValidator.java
public class AddressValidator {

    public boolean isValidAddress(String address) {
        // Allow only alphanumeric, spaces, and basic punctuation
        String validPattern = "^[a-zA-Z0-9 .,'-]+$";
        if (address == null || address.trim().isEmpty() || !address.matches(validPattern)) {
            return false;
        }
        return true;
    }
    // In validation logic, add sanitization or show user-friendly error if invalid
}
```
**Fix applied:**  
Added an additional check: address.trim().isEmpty() to ensure that empty or whitespace-only addresses are considered invalid, while preserving all original logic.