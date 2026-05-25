// hybris/core/AddressValidator.java
public class AddressValidator {
    // Fix: ESCAPE '-' in the regex to avoid range issues and allow '.' literally
    private static final String SUPPORTED_CHAR_PATTERN = "^[a-zA-Z0-9\\s,\\.\\-]+$";

    public boolean isValid(String address) {
        if (address == null || address.isEmpty()) {
            return false;
        }
        if (!address.matches(SUPPORTED_CHAR_PATTERN)) {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }
        // additional validation...
        return true;
    }
    // Recommendation: Also ensure frontend validation restricts entry of '@' and other unsupported characters.
}
```
**Note:** The fix applied escapes `.` and `-` in the regex pattern to ensure they are matched literally, preventing unintended range interpretation and matching unsupported special characters. All original logic is preserved and unchanged except for the corrected regex pattern.