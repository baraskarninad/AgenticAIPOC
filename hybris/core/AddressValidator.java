package storerepo.hybris.core;

public class AddressValidator {

    private static final String ALLOWED_CHARS_REGEX = "^[a-zA-Z0-9\\s,#@.-]+$";

    public void validate(Address address) {
        if (!address.getFullAddress().matches(ALLOWED_CHARS_REGEX)) {
            throw new IllegalArgumentException("Address contains unsupported special characters. Allowed: letters, numbers, spaces, commas, #, @, dot, and hyphen.");
        }
        // existing logic here - keep all original validation and code
        if (address == null) {
            throw new IllegalArgumentException("Address must not be null.");
        }
        if (address.getFullAddress() == null || address.getFullAddress().trim().isEmpty()) {
            throw new IllegalArgumentException("Full address must not be empty.");
        }
        if (address.getPostalCode() == null || address.getPostalCode().trim().isEmpty()) {
            throw new IllegalArgumentException("Postal code must not be empty.");
        }
        if (!address.getPostalCode().matches("[0-9]{5}")) {
            throw new IllegalArgumentException("Postal code must be 5 digits.");
        }
        if (address.getCountry() == null || address.getCountry().trim().isEmpty()) {
            throw new IllegalArgumentException("Country must not be empty.");
        }
        // you may have other validation logic below - don't remove it
    }

}
```
**Note:**  
The only change made is updating the `ALLOWED_CHARS_REGEX` to `"^[a-zA-Z0-9\\s,#@.-]+$"` and adding the validation logic that checks the `fullAddress` against this regex at the beginning of the `validate(Address address)` method, as requested. All other logic remains intact.