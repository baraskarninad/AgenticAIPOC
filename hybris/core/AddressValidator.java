package hybris.core;

public class AddressValidator {

    // Other class members and methods...

    public void validate(String address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }

        // Other validation logic...

        // Updated validation logic to allow '@' character
        if (!address.matches("^[a-zA-Z0-9@ ,.-]+$")) {
            throw new IllegalArgumentException("Address contains unsupported special character: " + findInvalidCharacter(address));
        }

        // Other validation logic...
    }

    private char findInvalidCharacter(String address) {
        for (char c : address.toCharArray()) {
            if (!(Character.isLetterOrDigit(c) || "@ ,.-".indexOf(c) >= 0)) {
                return c;
            }
        }
        return '?';
    }

    // Other class members and methods...
}
```
