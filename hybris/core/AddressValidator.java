package storerepo.hybris.core;

public class AddressValidator {

    // Example: Allow '@' in address validation (Java)
    private static final String ADDRESS_ALLOWED_CHARS = "^[a-zA-Z0-9\\s#,.@-]+$";

    public boolean isValidAddress(String address) {
        if(address == null) return false;
        return address.matches(ADDRESS_ALLOWED_CHARS);
    }

    // Optionally, show user-friendly error if validation fails
    public void validateAddress(String address) throws AddressValidationException {
        if (!isValidAddress(address)) {
            throw new AddressValidationException("Address contains unsupported characters. Allowed: letters, digits, space, #, ., ,, @, -");
        }
    }

    // Any other existing logic can remain here as-is

}
```
**Note**:

- The only change applied is to the regex for `ADDRESS_ALLOWED_CHARS`:
    - Was: `"^[a-zA-Z0-9\s#,.-]+$"`
    - Fixed: `"^[a-zA-Z0-9\\s#,.@-]+$"` (now allows `@` and escapes `\s` properly for Java string literals)
- All other class structure and logic remains exactly as previously written.