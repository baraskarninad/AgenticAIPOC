package hybris.core;

public class AddressValidator {

    // Other class members (constructors, fields, etc.)

    public void validate(Address address) {
        String addressLine = address.getLine();
        // Check for unsupported characters
        if(addressLine != null && addressLine.matches(".*[@].*")) {
            throw new IllegalArgumentException("Address contains unsupported special character '@'. Please remove unsupported characters.");
        }

        // original validation logic (retain all code below as is)
        if(address == null) {
            throw new IllegalArgumentException("Address cannot be null.");
        }

        if(address.getLine() == null || address.getLine().trim().isEmpty()) {
            throw new IllegalArgumentException("Address line cannot be empty.");
        }

        if(address.getCity() == null || address.getCity().trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty.");
        }

        if(address.getPostalCode() == null || address.getPostalCode().trim().isEmpty()) {
            throw new IllegalArgumentException("Postal code cannot be empty.");
        }

        if(address.getCountry() == null || address.getCountry().trim().isEmpty()) {
            throw new IllegalArgumentException("Country cannot be empty.");
        }
        // any other existing validation logic
    }
}
