package storerepo.hybris.core;

import java.util.regex.Pattern;

public class AddressValidator {

    // Update allowedChars set to include '@' if required
    private static final String allowedChars = "A-Za-z0-9#.,-@ ";

    public void validate(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        Pattern p = Pattern.compile("^[" + allowedChars + "]+$");
        if (!p.matcher(address).matches()) {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }
        // ... other validations
    }

    // Or, if '@' is not permitted, ensure users are warned and told to remove it before submitting.
}
