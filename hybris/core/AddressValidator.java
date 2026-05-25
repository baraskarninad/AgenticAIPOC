package hybris.core;

public class AddressValidator {

    public boolean isValidAddress(String address) {
        // Allow only alphanumerics, spaces, comma, hyphen
        if (address == null) return false;
        String regex = "^[a-zA-Z0-9\\s,\\-]+$";
        return address.matches(regex);
    }

    public void validateAddress(String address) {
        if (!isValidAddress(address)) {
            throw new ValidationException("Address contains invalid characters. Allowed: letters, numbers, spaces, comma, hyphen.");
        }
    }

    // Other existing methods and logic can be here
}
