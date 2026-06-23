// hybris/core/AddressValidator.java

import java.util.regex.Pattern;

public class AddressValidator {
    private static final Pattern ALLOWED_CHARS = Pattern.compile("^[a-zA-Z0-9 ,.\\-']+$"); // Adjust pattern to business needs

    public boolean isValid(String addressInput) {
        if (addressInput == null) return false;
        return ALLOWED_CHARS.matcher(addressInput).matches();
    }

    // If you need to support additional characters, modify the regex above.
    // Optionally: implement logging to detail which characters are rejected for easier troubleshooting.
}