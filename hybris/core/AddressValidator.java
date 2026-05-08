package hybris.core;

public class AddressValidator {

    public void validate(String address) {
        // Before:
        // if (address.contains("@")) {
        //     throw new IllegalArgumentException("Address contains unsupported special character '@'");
        // }

        // After (allow '@' if business approves):
        // List unsupported chars: e.g., only reject things like ';', '|', etc.
        String unsupportedChars = ";|";
        for (char c : unsupportedChars.toCharArray()) {
            if (address.indexOf(c) != -1) {
                throw new IllegalArgumentException("Address contains unsupported special character '" + c + "'");
            }
        }
        // Now '@' is allowed unless business says otherwise.

        // Existing logic (do not remove or modify)
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        if (address.length() > 255) {
            throw new IllegalArgumentException("Address is too long");
        }
        // Additional validation can be added here as required by business rules
    }

}
```
This version preserves all existing logic, replaces the single char check with a flexible unsupportedChars list, and allows '@' unless specifically disallowed. No existing logic is removed or abstracted.