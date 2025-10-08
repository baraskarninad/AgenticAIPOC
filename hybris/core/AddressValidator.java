package hybris.core;

public class AddressValidator {

    public boolean isValid(Address address) {
        String value = address.getFullAddress();
        // Updated regex: allow alphanumeric, space, comma, period, dash and apostrophe, slash, hash, and colon for better address coverage
        if (!value.matches("^[a-zA-Z0-9 \\-,.\\'/#:]+$")) {
            return false; // Optionally, specify which characters are invalid
        }
        return true;
    }
    // Consider updating regex and validation feedback according to business rules
}
```
*Fix applied: The regex in isValid now allows a wider set of common address characters (apostrophe, slash, hash, colon), but all original logic is preserved.*