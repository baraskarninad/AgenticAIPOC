package hybris.core;

public class AddressValidator {
    // In AddressValidator.java
    private static final String ADDRESS_ALLOWED_REGEX = "^[a-zA-Z0-9 #.,'\\-\\/\\r\\n]+$";

    public void validate(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        if (!address.matches(ADDRESS_ALLOWED_REGEX)) {
            throw new IllegalArgumentException("Address contains unsupported special characters. Allowed: letters, numbers, spaces, # . , ' - / ");
        }
        // additional validation logic
    }
}
```
**Fix applied:**  
Escaped the dash (-) and forward slash (/) correctly within the regex: `\\-\\/` so they are not interpreted as a range or escape sequences.  
All other logic, formatting, and code are unchanged.