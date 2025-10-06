// In hybris/core/AddressValidator.java
public class AddressValidator {
    public void validate(String address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        // Define allowed characters (example: letters, numbers, spaces, commas, periods, etc.)
        if (!address.matches("[a-zA-Z0-9\\s,\\.\\-]+")) {  // FIX: Properly escape regex for \s . -
            throw new IllegalArgumentException("Address contains unsupported special characters. Allowed: letters, numbers, spaces, commas, periods, hyphens.");
        }
        // Continue with other validations
    }
}
```
