// In hybris/core/AddressValidator.java
package hybris.core;

public class AddressValidator {

    // Add '@' to the ALLOWED_CHARACTERS as its inclusion is business-approved.
    private static final String ALLOWED_CHARACTERS = "A-Za-z0-9 ,.-#@";

    public void validate(String address) {
        if (address.matches("^[" + ALLOWED_CHARACTERS + "]+$")) {
            // pass
        } else {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }
    }

    // Add '@' to the ALLOWED_CHARACTERS if its inclusion is business-approved.
}
