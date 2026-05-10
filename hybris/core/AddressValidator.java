// src/hybris/core/AddressValidator.java

public class AddressValidator {
    // Fix: Modified regex to correctly escape backslash for whitespace, and accept Unicode letters for international addresses.
    // Previous: "^[A-Za-z0-9\s.,'-]*$"
    // New: "^[\\p{L}0-9 .,\\-'’]*$"     // \p{L} allows all unicode letters. Added typographic apostrophe ’.
    private static final String ALLOWED_CHARS_REGEX = "^[\\p{L}0-9 .,\\-'’]*$";

    public boolean validateAddressField(String field) {
        if (field == null) return false;
        return field.matches(ALLOWED_CHARS_REGEX);
    }

    // In your address validation logic:
    public boolean validateAddress(Address address) {
        if (!validateAddressField(address.getStreet())) return false;
        if (!validateAddressField(address.getCity())) return false;
        if (!validateAddressField(address.getPostalCode())) return false;
        // add more fields as needed
        return true;
    }
}
// Ensure this regex only blocks truly invalid chars, and update it as per project requirements. Also add frontend validation for these fields.
```
**Explanation of Fix:**
- The original regex `"^[A-Za-z0-9\s.,'-]*$"` did not correctly allow for all international letters, and the escape for whitespace (`\s`) is not reliably supported inside string literals without double escaping (should be `\\s`).
- Changed to `^[\\p{L}0-9 .,\\-'’]*$`:
    - `\\p{L}` allows all Unicode letters (so street/city names with non-English characters are valid).
    - Allowed space, dot, comma, hyphen, single quotes (both ASCII `'` and typographic `’`).
    - Double backslashes ensure correct escaping in Java string literals.

All original logic is preserved; only the regex has been updated.