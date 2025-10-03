package hybris.core;

public class AddressValidator {

    public void validate(String address) {
        if(address == null) {
            throw new IllegalArgumentException("Address cannot be null.");
        }
        // Improved invalid character handling and error messaging
        if (!address.matches("[A-Za-z0-9.,\\-\\s]+")) {
            // Find unsupported characters
            String invalidChars = address.replaceAll("[A-Za-z0-9.,\\-\\s]", "");
            throw new IllegalArgumentException(
                "Address contains unsupported special character(s): '" + invalidChars +
                "'. Allowed characters are: letters, numbers, comma, period, hyphen, and space."
            );
        }

        if(address.length() < 5) {
            throw new IllegalArgumentException("Address is too short. It must be at least 5 characters long.");
        }
        if(address.length() > 100) {
            throw new IllegalArgumentException("Address is too long. It must be no more than 100 characters long.");
        }
        // Other validation can be added here as required
    }

}
