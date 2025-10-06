package hybris.core;

public class AddressValidator {

    private static final String ADDRESS_ALLOWED_CHARS_REGEX = "^[a-zA-Z0-9\\s#@\\-,.']+$";

    // Other methods and logic...

    public static boolean isAddressValid(String address) {
        if (address == null || !address.matches(ADDRESS_ALLOWED_CHARS_REGEX)) {
            // Find the first invalid character if possible
            if (address != null) {
                for (int i = 0; i < address.length(); i++) {
                    char c = address.charAt(i);
                    if (!isAllowedAddressChar(c)) {
                        throw new IllegalArgumentException(
                                "Address contains unsupported special character: '" + c + "' at position " + i
                                        + ". Allowed: letters, numbers, space, #, @, -, ., '");
                    }
                }
            }
            // fallback, should not reach here unless address is null
            throw new IllegalArgumentException("Address contains unsupported special character(s). Allowed: letters, numbers, space, #, @, -, ., '");
        }
        return true;
    }

    private static boolean isAllowedAddressChar(char c) {
        return (c >= 'a' && c <= 'z')
                || (c >= 'A' && c <= 'Z')
                || (c >= '0' && c <= '9')
                || c == ' ' || c == '#' || c == '@' || c == '-' || c == '.' || c == '\'' || c == ',';
    }

    // Other existing methods and logic...
}
```
