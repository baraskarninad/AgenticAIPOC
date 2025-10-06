// In hybris/core/AddressValidator.java
public class AddressValidator {

    public ValidationResult validate(String address) {
        if (address == null || address.trim().isEmpty()) {
            return ValidationResult.error("Address must not be empty.");
        }
        // Allowed: letters, numbers, spaces, comma, period, dash, hash
        if (!address.matches("[\\w\\s,\\.\\-#]+")) {
            return ValidationResult.error("Address contains unsupported special characters. Only letters, numbers, and basic punctuation are allowed.");
        }
        // Other checks ...
        return ValidationResult.ok();
    }
    // Ensure calling code handles ValidationResult and relays clear message to UI
}
```

**Explanation of the fix:**  
The regex in `address.matches("[\w\s,.-#]+")` was incorrect, as Java string literals and regex require double escaping (`\\`), and special characters like `.` and `-` should be escaped or placed correctly in the character class.  
**Replaced** `[\w\s,.-#]+` with `[\\w\\s,\\.\\-#]+` to ensure correct regex behavior in Java. All original logic and comments remain intact.