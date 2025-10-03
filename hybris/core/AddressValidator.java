package hybris.core;

public class AddressValidator {

    // Example fix inside hybris/core/AddressValidator.java or relevant input handler
    public boolean isAddressValid(String address) {
        if (address.contains("@")) {
            throw new IllegalArgumentException("Address contains unsupported special character '@'");
        }
        // proceed with other validation logic
        return true;
    }
    // Alternatively, sanitize input before validation:
    public String sanitizeAddress(String address) {
        if (address == null) {
            return null;
        }
        return address.replaceAll("[@]", "");
    }
}
