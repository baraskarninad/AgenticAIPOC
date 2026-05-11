package hybris.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressValidator {

    private static final Logger log = LoggerFactory.getLogger(AddressValidator.class);

    public boolean validate(Address address) {
        // Input sanitation logic for street field
        String sanitizedStreet = address.getStreet().replaceAll("[^a-zA-Z0-9\\s]", "");
        if (!sanitizedStreet.equals(address.getStreet())) {
            // Log and return validation error
            log.warn("Address contains invalid characters: " + address.getStreet());
            return false;
        }

        // Existing validation logic begins
        if (address == null) {
            log.error("Address object is null");
            return false;
        }
        if (address.getStreet() == null || address.getStreet().isEmpty()) {
            log.error("Street is empty");
            return false;
        }
        if (address.getCity() == null || address.getCity().isEmpty()) {
            log.error("City is empty");
            return false;
        }
        if (address.getPostalCode() == null || address.getPostalCode().isEmpty()) {
            log.error("Postal code is empty");
            return false;
        }
        if (!address.getPostalCode().matches("\\d{5}")) {
            log.error("Postal code format invalid: " + address.getPostalCode());
            return false;
        }
        // Insert any other validation checks as per business rules

        return true;
    }
}
```
**Note:** The regex in `replaceAll` is updated to `"[^a-zA-Z0-9\\s]"` for Java string escape correctness. All original logic is preserved.