package hybris.core;

import java.util.logging.Level;
import java.util.logging.Logger;

// In hybris/core/AddressValidator.java
public class AddressValidator {

    private static final Logger LOGGER = Logger.getLogger(AddressValidator.class.getName());

    // Example adjustment to allow '@' and other common special chars:
    private static final String ALLOWED_ADDRESS_CHARS = "[a-zA-Z0-9 \\-#.,'@]";

    public void validate(String address) {
        if (address == null || address.isEmpty()) {
            LOGGER.log(Level.WARNING, "Address validation failed: Address is empty or null.");
            throw new IllegalArgumentException("Address cannot be empty");
        }
        // Adjust regex to allow '@' and document behavior
        if (!address.matches("^" + ALLOWED_ADDRESS_CHARS + "+$")) {
            LOGGER.log(Level.WARNING, "Address validation failed: Unsupported special characters found in address: \"{0}\"", address);
            throw new IllegalArgumentException(
               "Address contains unsupported special characters. Allowed: letters, digits, - # . , ' @ and spaces "
            );
        }
        // (additional validations...)
    }

    // Also add clear logging and update frontend validation rules accordingly.
}
