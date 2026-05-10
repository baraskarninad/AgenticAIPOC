package hybris.core;

public class AddressValidator {

    // Existing logic and variables
    // ... other methods and fields ...

    // Update validation logic to optionally allow '@' character
    public boolean isValid(String address) {
        // Example: allow '@' if required by business logic
        String blacklist = "!#$%^&*()=+[]{}|;:'\",<>/?";
        boolean allowAt = true; // Set based on business requirements
        for (char c : address.toCharArray()) {
            if (blacklist.indexOf(c) >= 0) {
                return false;
            }
            if (!allowAt && c == '@') {
                return false;
            }
        }
        return true;
    }

    // Or, update the error message to explicitly mention unsupported characters.

    // ... any other existing logic ...
}
```
