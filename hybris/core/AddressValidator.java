package hybris.core;

public class AddressValidator {

    // Original: did not allow '@'
    // private static final String INVALID_CHARS_REGEX = "[^a-zA-Z0-9 ,.#-]";
    // To permit '@':
    private static final String INVALID_CHARS_REGEX = "[^a-zA-Z0-9 ,.#-@]";

    public void validate(String address) {
        if (address == null || address.isEmpty() || address.matches(INVALID_CHARS_REGEX)) {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }
        // Additional address validation logic if needed
        if (address.length() < 5) {
            throw new IllegalArgumentException("Address is too short");
        }
        if (address.length() > 100) {
            throw new IllegalArgumentException("Address is too long");
        }
        boolean hasLetter = false;
        boolean hasNumber = false;
        for (int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            }
        }
        if (!hasLetter) {
            throw new IllegalArgumentException("Address must contain at least one letter");
        }
        if (!hasNumber) {
            throw new IllegalArgumentException("Address must contain at least one number");
        }
        // Any other validation requirements can be added below
    }
}
```
