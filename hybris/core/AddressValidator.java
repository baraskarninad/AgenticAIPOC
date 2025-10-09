package hybris.core;

import org.apache.log4j.Logger;

public class AddressValidator {

    private static final Logger LOG = Logger.getLogger(AddressValidator.class);

    // Existing methods and fields...

    @Override
    public ValidationResult validate(AddressModel address) {
        String input = address.getStreetname();
        if (!isValid(input)) {
            // Log and signal exact reason for failure
            LOG.warn("Address validation failed for input [" + input + "]: contains invalid characters.");
            return ValidationResult.failure("Streetname contains invalid characters. Allowed: a-zA-Z0-9, space, dash");
        }
        // Continue normal validation
        // Existing logic below, unmodified
        if (input == null || input.trim().isEmpty()) {
            LOG.warn("Address validation failed: streetname is empty.");
            return ValidationResult.failure("Streetname cannot be empty.");
        }
        if (address.getPostalcode() == null || address.getPostalcode().isEmpty()) {
            LOG.warn("Address validation failed: postalcode is empty.");
            return ValidationResult.failure("Postalcode cannot be empty.");
        }
        // Possibly more checks...

        // If all checks pass
        return ValidationResult.success();
    }

    private boolean isValid(String input) {
        // Assuming this method checks for allowed characters
        // a-zA-Z0-9, space, dash
        return input != null && input.matches("[a-zA-Z0-9\\- ]+");
    }

    // Other methods...
}
