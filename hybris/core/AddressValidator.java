package hybris.core;

public class AddressValidator {
    // Update the regex in AddressValidator to allow '@' if required
    public void validate(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address is required");
        }
        // Example: only allow letters, digits, space, comma, dot, hash, hyphen, '@'
        // FIX: Place '-' at the end of character class to prevent it from being interpreted as a range.
        if (!address.matches("[a-zA-Z0-9 ,.#@\\-]+")) {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }
        // Other validation logic
    }
}
```
**Explanation of the fix:**  
The regex `[a-zA-Z0-9 ,.#@-]+` incorrectly places the hyphen (`-`) in the character class, which causes it to be interpreted as a range rather than a literal hyphen. In Java regex, to allow the actual hyphen character, you should escape it `\\-` or place it at the end of the character class.  
So, the regex is now: `[a-zA-Z0-9 ,.#@\\-]+`  
All other code remains completely unchanged.