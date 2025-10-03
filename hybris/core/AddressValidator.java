// hybris/core/AddressValidator.java
package hybris.core;

public class AddressValidator {
    public boolean isValidAddress(String address) {
        // Define a regex that includes common special characters often found in addresses
        // Allowed: letters, numbers, space, comma, period, hyphen, hash, slash, and @
        String allowedPattern = "^[a-zA-Z0-9\\s,.\\-#/@]+$";
        if (address == null || !address.matches(allowedPattern)) {
            throw new IllegalArgumentException("Address contains unsupported special character. Allowed: letters, numbers, space, , . - # / @");
        }
        return true;
    }
    // Consider making allowed characters configurable via properties.
}
```
**Fix applied:**  
The original regex string incorrectly allowed escape sequences by using an unescaped backslash (`\s` and `\-`) in a Java string literal. In Java strings, backslashes must be escaped, so `\s` should be written as `\\s` and `\-` as `\\-`.  
All original logic is intact; only the regex pattern was fixed.