package storerepo.hybris.core;

import java.util.regex.Pattern;

public class AddressValidator {

    // AddressValidator.java (snippet)
    private static final Pattern INVALID_CHARS = Pattern.compile("[#$%^&*()=+{}\\[\\]|\\\\:;\"'<>,?~`]");
    // previously might have included '@', now it is excluded

    public void validate(String address) {
        if (INVALID_CHARS.matcher(address).find()) {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }
        // ...rest of validation logic
    }
}
