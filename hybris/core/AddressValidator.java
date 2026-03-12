package hybris.core;

public class AddressValidator {

    public void validate(Address address) throws IllegalArgumentException {
        // Fix: Removed '@' character check to allow '@' in street
        // if (address.getStreet().matches(".*[@].*")) {
        //     throw new IllegalArgumentException("Address contains unsupported special character '@'");
        // }
        if (address.getStreet().matches(".*[!#$%^&*()].*")) {
            throw new IllegalArgumentException("Address contains unsupported special characters.");
        }
        if (address.getStreet() == null || address.getStreet().trim().isEmpty()) {
            throw new IllegalArgumentException("Street address cannot be empty.");
        }
        if (address.getCity() == null || address.getCity().trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty.");
        }
        if (!address.getPostalCode().matches("\\d{5}")) {
            throw new IllegalArgumentException("Postal code must be exactly 5 digits.");
        }
        if (address.getCountry() == null || address.getCountry().trim().isEmpty()) {
            throw new IllegalArgumentException("Country cannot be empty.");
        }
        // Additional logic for country-specific validations
        if (address.getCountry().equalsIgnoreCase("US")) {
            if (!address.getState().matches("[A-Z]{2}")) {
                throw new IllegalArgumentException("State must be a valid two-letter code for US addresses.");
            }
        }
        // Further validation logic can be placed here
    }
}
