package hybris.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressValidator {

    private static final Logger log = LoggerFactory.getLogger(AddressValidator.class);

    // hybris/core/AddressValidator.java - example fix
    public boolean isValidAddress(String address) {
        // Allowed characters pattern, adjust as needed
        String validPattern = "^[a-zA-Z0-9\\s\\-,.]+$";
        if (address == null || !address.matches(validPattern)) {
            StringBuilder invalidChars = new StringBuilder();
            if (address != null) {
                // Find all invalid characters
                for (char c : address.toCharArray()) {
                    if (!String.valueOf(c).matches("[a-zA-Z0-9\\s\\-,.]")) {
                        if (invalidChars.indexOf(String.valueOf(c)) == -1) {
                            if (invalidChars.length() > 0) invalidChars.append(", ");
                            invalidChars.append("'").append(c).append("'");
                        }
                    }
                }
            }
            if (invalidChars.length() > 0) {
                log.warn("Address validation failed due to invalid characters: {}. Invalid character(s): {}", address, invalidChars.toString());
            } else {
                log.warn("Address validation failed due to invalid characters: {}", address);
            }
            return false;
        }
        return true;
    }
    // Additional suggestion: provide more granular error messaging to indicate which characters were invalid.

}
