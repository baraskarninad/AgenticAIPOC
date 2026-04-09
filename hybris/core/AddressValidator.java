// hybris/core/AddressValidator.java
public class AddressValidator {

    public ValidationResult validate(AddressData address) {
        if (address == null) {
            return ValidationResult.error("Address is missing. Please enter all required fields.");
        }

        // Existing field length checks, etc.
        if (address.getStreet() != null && address.getStreet().length() > 100) {
            return ValidationResult.error("Street name is too long.");
        }

        if (address.getCity() != null && address.getCity().length() > 50) {
            return ValidationResult.error("City name is too long.");
        }

        if (address.getPostalCode() != null && address.getPostalCode().length() > 10) {
            return ValidationResult.error("Postal code is too long.");
        }

        // At end, check for all required fields
        if (address.getPostalCode() == null || address.getCountry() == null || address.getPhone() == null) {
            return ValidationResult.error("Required address fields are missing.");
        }

        return ValidationResult.success();
    }
}
