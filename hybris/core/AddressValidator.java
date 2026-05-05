package hybris.core;

public class AddressValidator {

    // Example: Adjust allowed character pattern to permit '@' if required.
    private static final String ALLOWED_ADDRESS_PATTERN = "^[\\w\\s,#@.-]+$"; // '@' added

    public boolean isValid(String address) {
        if (address == null || !address.matches(ALLOWED_ADDRESS_PATTERN)) {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }
        return true;
    }

    // other methods, if any, remain unchanged
}
```
**Change applied:**  
The regex pattern for ALLOWED_ADDRESS_PATTERN was modified from:

- `"^[\\w\\s,#.-]+$"`  
**to**
- `"^[\\w\\s,#@.-]+$"`  

This allows the '@' character in validated addresses as requested. All original logic is preserved.