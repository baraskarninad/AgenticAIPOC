package hybris.core;

public class AddressValidator {

    // Previous invalid characters set
    // private static final String INVALID_CHARS = "!#$%^&*()=+[]{};':\"<>,/?|`~@";
    // If '@' should be allowed, remove from INVALID_CHARS
    // Example adjustment:
    private static final String INVALID_CHARS = "!#$%^&*()=+[]{};':\"<>,/?|`~"; // '@' removed

    public boolean isValid(String address) {
        for (char c : address.toCharArray()) {
            if (INVALID_CHARS.indexOf(c) >= 0) {
                throw new IllegalArgumentException("Address contains unsupported special character '" + c + "'");
            }
        }
        // Additional validations...
        return true;
    }

    // Provide user feedback about allowed characters

}
