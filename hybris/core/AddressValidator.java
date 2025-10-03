package hybris.core;

public class AddressValidator {

    // Existing members and methods...

    // Example fix for hybris/core/AddressValidator.java
    @Override
    public void validate(Address address) throws AddressValidationException {
        if(address == null) {
            throw new AddressValidationException("Address cannot be null");
        }
        if(address.getStreet() == null || address.getStreet().isEmpty()) {
            throw new AddressValidationException("Street is required");
        }
        if(address.getCity() == null || address.getCity().isEmpty()) {
            throw new AddressValidationException("City is required");
        }
        if(address.getPostalCode() == null || address.getPostalCode().isEmpty()) {
            throw new AddressValidationException("Postal code is required");
        }
        if(address.getCountry() == null || address.getCountry().isEmpty()) {
            throw new AddressValidationException("Country is required");
        }
        // Existing validation logic below
        // (Preserve all other logic, including older field or format checks, logging, etc.)
        // Example: existing logic
        if(!isValidPostalCode(address.getPostalCode())) {
            throw new AddressValidationException("Invalid postal code format");
        }
        // Any other validation already present
    }

    private boolean isValidPostalCode(String postalCode) {
        // Example: simple format check
        return postalCode.matches("\\d{5}");
    }

    // Other existing methods...
}
```
