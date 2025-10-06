package hybris.core;

import java.util.regex.Pattern;

public class AddressValidator {

    public ValidationResult validate(String address) {
        if (address == null) {
            return ValidationResult.invalid("Address is required.");
        }
        // Block unsupported characters (e.g., '@')
        Pattern p = Pattern.compile("^[a-zA-Z0-9 #,\\.\\-]*$"); // add allowed characters; escape '.' and '-' for regex character class
        if (!p.matcher(address).matches()) {
            return ValidationResult.invalid("Address contains unsupported characters. Allowed: letters, numbers, spaces, #, ',', '.', '-'.");
        }
        // existing validations ...
        return ValidationResult.valid();
    }
}
