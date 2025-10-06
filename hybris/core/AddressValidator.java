package hybris.core;

import org.apache.log4j.Logger;

import java.util.regex.Pattern;

/**
 * Validates customer address input for format, length, and allowed characters.
 */
public class AddressValidator {

    private static final Logger LOG = Logger.getLogger(AddressValidator.class);
    private static final Pattern VALID_ADDRESS_PATTERN = Pattern.compile("^[a-zA-Z0-9 ,.-]+$");

    /**
     * Entry point for validating an address.
     *
     * @param address the address string to validate
     * @throws IllegalArgumentException if validation fails
     */
    public void validateAddress(String address) {
        LOG.info("Starting address validation process.");

        if (address == null) {
            LOG.error("Address input is null.");
            throw new NullPointerException("Address input cannot be null");
        }

        LOG.debug("Input address: \"" + address + "\"");

        checkEmpty(address);
        checkLength(address);
        checkCharacters(address);

        LOG.info("Address validation passed.");
    }

    /**
     * Checks if the address is empty.
     */
    private void checkEmpty(String address) {
        LOG.debug("Checking for empty fields...");
        if (address.trim().isEmpty()) {
            LOG.warn("Address is empty.");
            throw new IllegalArgumentException("Address cannot be empty");
        }
        LOG.debug("Empty field check passed.");
    }

    /**
     * Checks if the address length is within acceptable limits.
     */
    private void checkLength(String address) {
        LOG.debug("Checking address length...");
        if (address.length() > 255) {
            LOG.warn("Address exceeds maximum length.");
            throw new IllegalArgumentException("Address exceeds maximum allowed length");
        }
        LOG.debug("Length check passed.");
    }

    /**
     * Checks for invalid characters in the address.
     */
    private void checkCharacters(String address) {
        LOG.debug("Validating character set...");
        if (!VALID_ADDRESS_PATTERN.matcher(address).matches()) {
            for (char c : address.toCharArray()) {
                if (!Character.isLetterOrDigit(c) && " ,.-".indexOf(c) == -1) {
                    LOG.error("Invalid character '" + c + "' detected in address field.");
                    throw new IllegalArgumentException("Address contains unsupported special character '" + c + "'");
                }
            }
        }
        LOG.debug("Character set validation passed.");
    }
}
