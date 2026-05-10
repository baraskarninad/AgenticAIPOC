package hybris.core;

public class AddressValidator {

    public boolean validate(Address address) {
        if (address == null) return false;
        // Add checks for all required fields
        if (address.getStreet() == null || address.getStreet().isEmpty()) return false;
        if (address.getPostalCode() == null || address.getPostalCode().isEmpty()) return false;
        // Add pattern/length/edge case validation here

        // Fix: Added additional required field checks (if needed)
        if (address.getCity() == null || address.getCity().isEmpty()) return false;
        if (address.getCountry() == null || address.getCountry().isEmpty()) return false;

        // Optionally, validate postal code format (example - adjust regex as needed)
        if (!address.getPostalCode().matches("\\d{5}(-\\d{4})?")) return false;

        // You can add more validations as needed

        return true;
    }

}
```
