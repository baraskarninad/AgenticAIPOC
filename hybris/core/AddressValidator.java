// hybris/core/AddressValidator.java
public class AddressValidator {
    private static final String ALLOWED_CHAR_PATTERN = "^[a-zA-Z0-9 \\-,.]+$"; // adjust as per locale

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AddressValidator.class);

    public boolean isValid(String addressField) {
        if (addressField == null || !addressField.matches(ALLOWED_CHAR_PATTERN)) {
            log.warn("Address validation failed due to invalid characters.");
            return false;
        }
        return true;
    }
}