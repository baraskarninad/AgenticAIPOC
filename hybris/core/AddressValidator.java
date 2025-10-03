package hybris.core;

import java.util.regex.Pattern;

public class AddressValidator {
    // Updated pattern to allow '@' character
    private static final Pattern UNSUPPORTED_CHARS = Pattern.compile("[$&+,:;=\\?#|'<>.^*()%!-]");

    public void validate(String address) {
        if (UNSUPPORTED_CHARS.matcher(address).find()) {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }
        // ... existing logic ...
    }
}
