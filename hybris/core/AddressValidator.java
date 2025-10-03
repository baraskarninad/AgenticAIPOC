package hybris.core;

import java.util.regex.Pattern;

public class AddressValidator {

    public void validate(String addressField) {
        // Other validation logic

        // Before
        // if (addressField.matches(".*[@].*")) {
        //     throw new IllegalArgumentException("Address contains unsupported special character '@'");
        // }

        // After: allow '@' character, or make set of allowed special characters configurable
        String allowedSpecialChars = "-.,#@/ "; // extend as needed
        if (!addressField.matches("^[a-zA-Z0-9" + Pattern.quote(allowedSpecialChars) + "]+$")) {
            throw new IllegalArgumentException("Address contains unsupported special characters. Allowed: " + allowedSpecialChars);
        }

        // ... possible further validation logic
    }

    // ... possible other methods or logic
}
