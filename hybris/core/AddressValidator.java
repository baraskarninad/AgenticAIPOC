// hybris/core/AddressValidator.java
public class AddressValidator {

    // Allow common special characters in addresses, e.g., '-', '.', ',', '#' etc.
    // Fixed regex pattern: escape '\' is doubled (\\s, \\-, etc.)
    public boolean isValid(String address) {
        String allowedPattern = "^[a-zA-Z0-9\\s\\-\\.,#]+$";
        return address != null && address.matches(allowedPattern);
    }

    // Consider externalizing allowed characters or patterns to configuration for easier updates.

}
```
Explanation of Fix:  
The regex string must use double backslashes in Java string literals (e.g., "\\s" for whitespace, "\\-" for dash) to represent a single backslash in the regex engine. The original code used single backslashes (`\s`, `\-,` etc.), which is invalid in Java string literals and causes compile or runtime errors. The fix is to properly escape the backslashes within the pattern.  
No logic was removed or changed otherwise.