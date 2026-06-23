package hybris.core;

public class AddressValidator {

    // Update the validation regex/predicate as needed
    // FIX APPLIED: Added '@' to allowed pattern
    private static final String ALLOWED_ADDRESS_PATTERN = "^[a-zA-Z0-9\\s,#.-@]+$"; // Add '@' if now supported

    public boolean isValidAddress(String address) {
        if (address == null || !address.matches(ALLOWED_ADDRESS_PATTERN)) {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }
        return true;
    }
    // Adjust the pattern above as per business requirements.
}
