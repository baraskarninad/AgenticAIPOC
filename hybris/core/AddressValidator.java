// hybris/core/AddressValidator.java

package hybris.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressValidator {

    private static final Logger log = LoggerFactory.getLogger(AddressValidator.class);

    private static final String ALLOWED_CHARACTERS_REGEX = "^[a-zA-Z0-9 .,'-]+$";

    public boolean validate(Address address) {
        if (address == null) {
            log.warn("Address validation failed: Address is null.");
            throw new ValidationException("Address must not be null.");
        }
        if (address.getFullAddress() == null) {
            log.warn("Address validation failed: Full address is null.");
            throw new ValidationException("Full address must not be null.");
        }
        if (!address.getFullAddress().matches(ALLOWED_CHARACTERS_REGEX)) {
            log.warn("Address validation failed due to invalid characters.");
            throw new ValidationException("Address contains invalid characters. Allowed: letters, numbers, spaces, . , ' -");
        }
        //... further address validations
        return true;
    }

}
