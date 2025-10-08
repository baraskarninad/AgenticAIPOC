package hybris.core;

public class AddressValidator {

    // In hybris/core/AddressValidator.java
    private static final String ALLOWED_CHARACTERS_REGEX = "^[a-zA-Z0-9 .,#-]+$";

    public void validate(String address) {
        if (!address.matches(ALLOWED_CHARACTERS_REGEX)) {
            // Find and list all unsupported characters for user feedback
            String unsupported = address.replaceAll("[a-zA-Z0-9 .,#-]", "");
            throw new IllegalArgumentException("Address contains unsupported character(s): '" + unsupported + "'");
        }
        // existing validations
    }
    // Consider updating ALLOWED_CHARACTERS_REGEX to include additional symbols as per business requirements.
}
```
