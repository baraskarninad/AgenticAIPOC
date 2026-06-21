package hybris.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressValidator {

    private static final Logger log = LoggerFactory.getLogger(AddressValidator.class);

    // Allowed characters can now be configured for flexibility
    private String allowedCharsRegex = "[^a-zA-Z0-9\\s,.-]";

    /**
     * Sets the allowed character regex for address validation.
     * @param regex The regex pattern describing disallowed characters.
     */
    public void setAllowedCharsRegex(String regex) {
        this.allowedCharsRegex = regex;
    }

    public boolean validateAddress(String input) {
        String cleanInput = input.replaceAll(allowedCharsRegex, ""); // Allow configurable set
        if (!cleanInput.equals(input)) {
            log.warn("Address validation failed due to invalid characters.");
            return false;
        }
        // further validation logic
        return true;
    }

    // Consider making allowed characters configurable for flexibility.
}
```
