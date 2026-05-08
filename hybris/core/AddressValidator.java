package hybris.core;

public class AddressValidator {

    private static final String ALLOWED_CHAR_REGEX = "[^a-zA-Z0-9.,#@\s]";

    public boolean validate(String address) {
        // Clean input, allow '@' if desired
        String cleanedAddress = address.replaceAll(ALLOWED_CHAR_REGEX, "");
        // Validation logic...
        return !address.matches(".*[^a-zA-Z0-9.,#@\s].*");
    }

    // Other methods and logic remain unchanged
    // You may have additional constructors, fields, or methods here
}
```
