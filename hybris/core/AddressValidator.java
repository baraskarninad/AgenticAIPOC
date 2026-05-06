package hybris.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressValidator {

    // Fix: Updated regex to allow '@' character in addresses
    private static final Pattern INVALID_CHARACTERS = Pattern.compile("[^a-zA-Z0-9 .,/@-]");

    public ValidationResult validate(String address) {
        Matcher matcher = INVALID_CHARACTERS.matcher(address);
        if (matcher.find()) {
            // Optionally allow '@' or add exceptions
            char invalidChar = matcher.group().charAt(0);
            if (invalidChar == '@') {
                // Optionally allow '@', or warn
                // return ValidationResult.warn("'@' is rarely used in addresses, please confirm...");
                // Or allow
            } else {
                return ValidationResult.error("Address contains unsupported special character '" + invalidChar + "'");
            }
        }
        // Rest of validation logic
        return ValidationResult.success();
    }
}
