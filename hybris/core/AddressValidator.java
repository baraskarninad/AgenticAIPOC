package hybris.core;

public class AddressValidator {

    private static final String INVALID_ADDRESS_CHARS = "@#%$^&*()[]{}<>/\\|~`";

    // Assuming these are the existing dependencies. Keeping original logic intact.
    // import statements, class properties, and other methods

    public ValidationResult validate(Address address) {
        // New validation step for special characters in address fields
        for (char c : INVALID_ADDRESS_CHARS.toCharArray()) {
            if (address.getStreet() != null && address.getStreet().indexOf(c) >= 0) {
                return ValidationResult.invalid("Invalid character '" + c + "' detected in address field: street");
            }
            if (address.getCity() != null && address.getCity().indexOf(c) >= 0) {
                return ValidationResult.invalid("Invalid character '" + c + "' detected in address field: city");
            }
            // Optionally, add other fields here if required
            // e.g.
            // if (address.getState() != null && address.getState().indexOf(c) >= 0) { ... }
        }

        // --- Existing validation logic starts here (kept fully intact) ---
        if (address == null) {
            return ValidationResult.invalid("Address must not be null");
        }

        if (address.getStreet() == null || address.getStreet().trim().isEmpty()) {
            return ValidationResult.invalid("Street address must not be empty");
        }

        if (address.getCity() == null || address.getCity().trim().isEmpty()) {
            return ValidationResult.invalid("City must not be empty");
        }

        if (address.getPostalCode() == null || address.getPostalCode().trim().isEmpty()) {
            return ValidationResult.invalid("Postal code must not be empty");
        }

        if (address.getCountry() == null || address.getCountry().trim().isEmpty()) {
            return ValidationResult.invalid("Country must not be empty");
        }

        if (address.getPostalCode() != null && !address.getPostalCode().matches("\\d{5,6}")) {
            return ValidationResult.invalid("Invalid postal code format");
        }

        // Add any further custom validation here

        return ValidationResult.valid();
        // --- Existing validation logic ends here ---
    }

}
```
