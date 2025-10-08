// In hybris/core/AddressValidator.java
public class AddressValidator {

    public void validate(String address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        // Define allowed characters (A-Z, a-z, 0-9, space, comma, dot, dash, #, etc.)
        // FIX: Corrected regex to prevent escaping issues: \\s for space, \\., must escape dash at end, add apostrophe and slash if desired
        if (!address.matches("[a-zA-Z0-9\\s,\\.#\\-]+")) {
            throw new IllegalArgumentException("Address contains unsupported special characters. Please use only letters, numbers, spaces, and basic punctuation.");
        }
        // other validation logic ...
    }

    // Suggest updating frontend to check user input with same regex and show an immediate error to the user if the pattern is not matched.
}
```
**Fix applied:**  
- The regex in the `matches` method now uses double backslashes (`\\s`, `\\.`) to correctly represent Java regex:  
  `[a-zA-Z0-9\\s,\\.#\\-]+`  
- All original logic is left intact.  
- No code is deleted, summarized, or replaced with comments.  
- The fix ensures that addresses such as `123 Main St., Apt #5-B` will be validated correctly, matching the backend logic.