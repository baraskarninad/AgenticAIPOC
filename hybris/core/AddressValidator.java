package hybris.core;

public class AddressValidator {

    // Example adjustment in hybris/core/AddressValidator.java
    private static final String ALLOWED_ADDRESS_REGEX = "^[A-Za-z0-9 ,#.\\-]+$"; // add more allowed characters as needed

    public void validate(String address) {
        if(address == null || !address.matches(ALLOWED_ADDRESS_REGEX)) {
            throw new IllegalArgumentException("Address contains unsupported special character(s). Allowed: letters, numbers, comma, space, #, ., -");
        }
        // Continue with validation...
    }

    // other methods, if any, remain unchanged
}
```
**Note:**  
The only necessary modification is escaping the dash `-` in the regex (`\\-`) to ensure correct character class definition. All other code remains unchanged.