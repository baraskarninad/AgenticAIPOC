package your.package.name; // Adjust this as needed

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressValidator {
    private static final Logger logger = LoggerFactory.getLogger(AddressValidator.class);

    // Example snippet for AddressValidator
    public boolean isValidAddress(String address) {
        // Only allow alphanumeric, spaces, and basic punctuation
        // Reject '@' or other invalid characters
        if (address == null) return false;
        // FIX: Escape the dash to avoid regex ambiguity, and use double backslash for Java string
        String allowedPattern = "^[a-zA-Z0-9\\s,\\.\\-]+$";
        if (!address.matches(allowedPattern)) {
            // Log invalid address reason
            logger.warn("Address validation failed due to invalid characters: " + address);
            return false;
        }
        return true;
    }

    // Use this method wherever address fields are validated.
}
```
**Key Fix:**  
The pattern string is now `"^[a-zA-Z0-9\\s,\\.\\-]+$"`, using double backslashes to properly escape regex characters for Java string literals:
- `\\s` for whitespace
- `\\.` for dot
- `\\-` for dash

All other logic and structure is fully retained as originally provided.