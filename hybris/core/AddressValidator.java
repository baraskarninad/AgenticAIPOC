// In hybris/core/AddressValidator.java
// Example: Adjust the regular expression to allow '@' only if permitted by business rules
package hybris.core;

public class AddressValidator {

    // Example: Adjust the regular expression to allow '@' only if permitted by business rules
    // Fixed regex: Escape '-' to be last or first or escape properly; '/' does not need escaping in a character class.
    // The hyphen should be either at the start/end or escaped; here moving it to the end.
    private static final String ADDRESS_ALLOWED_PATTERN = "^[a-zA-Z0-9 ,#@/\\-]+$";

    public boolean isValid(String address) {
        if (address == null) return false;
        return address.matches(ADDRESS_ALLOWED_PATTERN); // allow @
    }

}
```
