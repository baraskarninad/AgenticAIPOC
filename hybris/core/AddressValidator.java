package hybris.core;

public class AddressValidator {

    @Override
    public void validate(Address address) throws IllegalArgumentException {
        if(address == null) {
            throw new IllegalArgumentException("Delivery address must not be null");
        }
        String value = address.getStreet(); // replace with actual field(s)
        if(value == null || value.matches(".*[@].*")) {
            throw new IllegalArgumentException("Address contains unsupported special character '@'");
        }
        // Add checks for other unsupported characters as needed

        // Existing validation logic ...
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("Street address cannot be empty");
        }
        if (address.getCity() == null || address.getCity().trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty");
        }
        if (address.getPostalCode() == null || address.getPostalCode().trim().isEmpty()) {
            throw new IllegalArgumentException("Postal code cannot be empty");
        }
        if (address.getCountry() == null) {
            throw new IllegalArgumentException("Country cannot be null");
        }
        // Possibly more validation rules depending on business requirements
    }
}
