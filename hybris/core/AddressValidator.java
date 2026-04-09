package hybris.core;

public class AddressValidator {

    public ValidationResult validateShippingAddress(AddressData address) {
        // Start of added validations for all required fields
        
        if (address.getPostcode() == null || !isValidPostcode(address.getPostcode())) {
            return ValidationResult.fail("Invalid or missing postcode.");
        }
        if (address.getCity() == null || address.getCity().trim().isEmpty()) {
            return ValidationResult.fail("City is required.");
        }
        if (address.getMobile() == null || !isValidMobile(address.getMobile())) {
            return ValidationResult.fail("Invalid mobile number.");
        }
        if (address.getStreet() == null || address.getStreet().trim().isEmpty()) {
            return ValidationResult.fail("Street is required.");
        }
        if (address.getCountry() == null || address.getCountry().trim().isEmpty()) {
            return ValidationResult.fail("Country is required.");
        }
        if (address.getFirstName() == null || address.getFirstName().trim().isEmpty()) {
            return ValidationResult.fail("First name is required.");
        }
        if (address.getLastName() == null || address.getLastName().trim().isEmpty()) {
            return ValidationResult.fail("Last name is required.");
        }
        if (address.getEmail() == null || !isValidEmail(address.getEmail())) {
            return ValidationResult.fail("Invalid or missing email address.");
        }
        if (address.getRegion() == null || address.getRegion().trim().isEmpty()) {
            return ValidationResult.fail("Region is required.");
        }
        // Add additional fields here if necessary
        
        // End of added validations for all required fields
        
        // Existing logic starts here (keep all original validation logic, do not remove or abstract)
        // For example, if you have extra business logic, keep it:
        if (!customBusinessRulesValidation(address)) {
            return ValidationResult.fail("Custom business rule validation failed.");
        }
        // End of existing logic
        
        return ValidationResult.success();
    }

    private boolean isValidPostcode(String postcode) {
        // Simplified postcode validation
        return postcode.matches("\\d{5}") || postcode.matches("[A-Z0-9\\- ]{3,10}");
    }

    private boolean isValidMobile(String mobile) {
        // Basic mobile validation: optional +, 8-15 digits
        return mobile.matches("^\\+?\\d{8,15}$");
    }

    private boolean isValidEmail(String email) {
        // Basic email validation
        return email.matches("^[\\w-\\.]+@[\\w-\\.]+\\.[A-Za-z]{2,6}$");
    }

    private boolean customBusinessRulesValidation(AddressData address) {
        // Placeholder for any additional validation logic
        return true;
    }

}
```
