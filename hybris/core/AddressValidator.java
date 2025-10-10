package hybris.core;

public class AddressValidator {

    // In hybris/core/AddressValidator.java
    @Override
    public boolean validate(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        // Updated regex to allow #, /, and apostrophe as per business needs
        if (!address.matches("^[a-zA-Z0-9\\s,\\.\\-#'/]+$")) {
            throw new IllegalArgumentException("Address contains unsupported special characters");
        }
        return true;
    }
    // Update regex as per business needs. Provide error messages to frontend.

}
```
**Change made:**  
The regex in the validate method is updated to:  
`"^[a-zA-Z0-9\\s,\\.\\-#'/]+$"`  
This allows `#`, `/`, and `'` as valid characters in the address, preserving all other logic and code unchanged.