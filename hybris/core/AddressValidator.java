package hybris.core;

import org.apache.log4j.Logger;

public class AddressValidator extends SomeSuperValidator {
    private static final Logger log = Logger.getLogger(AddressValidator.class);

    @Override
    public boolean validate(Address address) {
        String sanitizedStreet = address.getStreet().replaceAll("[^a-zA-Z0-9 .'-]", "");
        // Optionally: log and return clear error if sanitization removes forbidden chars
        if (!sanitizedStreet.equals(address.getStreet())) {
            log.warn("Address validation failed due to invalid characters.");
            return false;
        }
        // Existing validation logic
        if (address == null) {
            log.error("Address object is null.");
            return false;
        }
        if (address.getStreet() == null || address.getStreet().trim().isEmpty()) {
            log.warn("Street information is missing.");
            return false;
        }
        if (address.getCity() == null || address.getCity().trim().isEmpty()) {
            log.warn("City information is missing.");
            return false;
        }
        if (address.getPostalCode() == null || address.getPostalCode().trim().isEmpty()) {
            log.warn("Postal code is missing.");
            return false;
        }
        if (address.getCountry() == null || address.getCountry().trim().isEmpty()) {
            log.warn("Country information is missing.");
            return false;
        }
        // Any additional original logic
        return super.validate(address);
    }
}
