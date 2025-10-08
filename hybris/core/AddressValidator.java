package hybris.core;

import java.util.regex.Pattern;
import org.apache.log4j.Logger;

public class AddressValidator {
    private static final Logger log = Logger.getLogger(AddressValidator.class);

    public boolean isAddressValid(String address) {
        // Reject if address contains invalid characters, including '@'
        Pattern INVALID = Pattern.compile("[!#$%&'*+/=?^_`{|}~@]");
        java.util.regex.Matcher matcher = INVALID.matcher(address);
        if (matcher.find()) {
            char invalidChar = address.charAt(matcher.start());
            log.error("Invalid character detected in address field: '" + invalidChar + "'");
            return false;
        }
        // Example of existing validation logic
        if (address == null || address.trim().isEmpty()) {
            log.error("Address cannot be null or empty.");
            return false;
        }
        if (address.length() < 5) {
            log.error("Address is too short.");
            return false;
        }
        if (address.length() > 100) {
            log.error("Address is too long.");
            return false;
        }
        // Add any other specific validation requirements as per business rules
        // Example check: starts with a digit (house number)
        if (!Character.isDigit(address.charAt(0))) {
            log.error("Address must start with a house number.");
            return false;
        }
        // If all checks pass
        return true;
    }
}
