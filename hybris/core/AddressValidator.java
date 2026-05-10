package hybris.core;

public class AddressValidator {

    public boolean validate(String address) {
        if (address == null) return false;
        // Reject unsupported special characters (e.g. @)
        if (address.matches(".*[@].*")) {
            // Optionally provide feedback to user
            throw new IllegalArgumentException("Address contains unsupported special character '@'");
        }
        // Continue existing validation...
        return true;
    }

}
