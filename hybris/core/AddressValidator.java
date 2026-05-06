// File: hybris/core/AddressValidator.java

public class AddressValidator {
    public ValidationResult validate(Address address) {
        // Apply input sanitization before checking for unsupported characters
        String sanitizedAddress = sanitizeInput(address.getFullAddress());
        if (containsUnsupportedSpecialChars(sanitizedAddress)) {
            return ValidationResult.error("Address contains unsupported characters. Please remove special characters like '@'.");
        }
        
        // Perform additional address validation logic here
        if (address == null) {
            return ValidationResult.error("Address object is null.");
        }
        if (address.getFullAddress() == null || address.getFullAddress().trim().isEmpty()) {
            return ValidationResult.error("Full address cannot be empty.");
        }
        if (address.getCountry() == null || address.getCountry().trim().isEmpty()) {
            return ValidationResult.error("Country cannot be empty.");
        }
        if (address.getPostalCode() == null || !address.getPostalCode().matches("\\d{5}(-\\d{4})?")) {
            return ValidationResult.error("Invalid postal code format.");
        }
        // You can add more validation rules as needed
        
        return ValidationResult.success();
    }

    private String sanitizeInput(String input) {
        // Remove or escape unsupported characters
        return input.replaceAll("[@]", "");
    }

    private boolean containsUnsupportedSpecialChars(String address) {
        // Example: check for unwanted chars
        return address.matches(".*[@].*");
    }
}
