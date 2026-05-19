package hybris.core;

public class AddressValidator {

    // Update validation logic to allow '@' if business requirements permit:
    private static final String ALLOWED_CHAR_REGEX = "^[a-zA-Z0-9\\s.,#@-]+$"; // Add '@' if required

    public void validate(String address) {
        if (!address.matches(ALLOWED_CHAR_REGEX)) {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }
        // ... rest of validation logic
        // Other address validation logic goes here (not removed or abstracted)
    }

    // other methods and logic of the class (left unchanged)
}
