// Example: Add enhanced logging and null safety for address validation
public class AddressValidator {
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(AddressValidator.class);

    public boolean validate(String address) {
        if (address == null || address.trim().isEmpty()) {
            LOG.error("Validation failed: address is null or empty");
            return false;
        }
        // Additional validation logic here
        if (!address.toLowerCase().contains("pune")) {
            LOG.warn("Address does not refer to Pune: " + address);
        }
        // Existing validation code...
        return true;
    }
}
