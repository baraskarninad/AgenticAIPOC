package hybris.core;

public class AddressValidator {

    // Other methods and members...

    // Old code:
    /*
    public void validate(String address) {
        if (address.matches(".*[@].*")) {
            throw new IllegalArgumentException("Address contains unsupported special character '@'");
        }
        // ... existing validation logic ...
    }
    */

    // Corrected code:
    public void validate(String address) {
        // Example: allow '@' as valid
        if (address.matches(".*[^a-zA-Z0-9#., \\-@].*")) {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }
        // ... existing validation logic ...
    }

    // ... rest of the class ...
}
