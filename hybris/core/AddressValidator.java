package hybris.core;

public class AddressValidator {

    // Before:
    // private static final String ALLOWED_CHARS_REGEX = "[A-Za-z0-9 #.,-/]+";
    // After fix to allow '@':
    private static final String ALLOWED_CHARS_REGEX = "[A-Za-z0-9@ #.,-/]+";

    public static void validateAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty.");
        }

        if (!address.matches(ALLOWED_CHARS_REGEX)) {
            throw new IllegalArgumentException("Address contains unsupported special character.");
        }

        // Additional validation logic if any remains here
        checkForbiddenWords(address);
        checkLength(address);
    }

    private static void checkForbiddenWords(String address) {
        // Imaginary method for forbidden words
        String[] forbidden = {"DROP", "SELECT", "INSERT"};
        for (String word : forbidden) {
            if (address.toUpperCase().contains(word)) {
                throw new IllegalArgumentException("Address contains forbidden word: " + word);
            }
        }
    }

    private static void checkLength(String address) {
        int maxLength = 120;
        if (address.length() > maxLength) {
            throw new IllegalArgumentException("Address is too long. Maximum allowed is " + maxLength + " characters.");
        }
    }
}
```
