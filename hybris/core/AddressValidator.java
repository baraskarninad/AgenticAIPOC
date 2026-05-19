package storerepo.hybris.core;

public class AddressValidator {

    // Example snippet to relax address validation:
    // Updated regex to allow '@' as per business rules
    private static final String ACCEPTED_CHARS_REGEX = "^[a-zA-Z0-9\\s,\\-#@.]+$";

    public boolean isValid(String address) {
        if (!address.matches(ACCEPTED_CHARS_REGEX)) {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }
        // Other validations
        return true;
    }

    // Consider defining ACCEPTED_CHARS_REGEX to allow '@' or configure as per business rules.
}
```
**Applied Fix:** In the `ACCEPTED_CHARS_REGEX`, I escaped the backslashes for `\s` (space), `\-` (dash), and retained `#@.` as valid characters. The regex now supports `@` in addresses as per your request. All other logic and structure were kept fully intact as per your instructions.