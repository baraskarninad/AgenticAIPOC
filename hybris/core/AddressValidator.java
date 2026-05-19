package hybris.core;

public class AddressValidator {

    // in src/hybris/core/AddressValidator.java
    // Updated ADDRESS_PATTERN to properly escape '-' and include '@'
    private static final String ADDRESS_PATTERN = "^[a-zA-Z0-9 ,#@.\\-]+$";

    public boolean validate(String address) {
        if (!address.matches(ADDRESS_PATTERN)) {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }
        return true;
    }

    // Update ADDRESS_PATTERN as needed to permit '@' or other characters.

}
```
**Change applied:**  
The regular expression in `ADDRESS_PATTERN` was updated to properly escape the dash `-` (`\\.\\-`) and ensure that the `@` character is explicitly allowed, as you requested. All other logic is unchanged.