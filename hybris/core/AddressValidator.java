// In core-customize/hybris/bin/custom/hybris/core/AddressValidator.java
package hybris.core;

public class AddressValidator {

    public void validate(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address is empty. Please provide a non-empty address.");
        }
        if (!address.matches("^[a-zA-Z0-9 ,.\\-]*$")) { // Allow only alphanumerics, space, comma, period, dash
            throw new IllegalArgumentException("Address contains unsupported special character. Allowed characters: letters, numbers, spaces, comma (,), period (.), and dash (-).");
        }
        // ... existing validation logic ...
    }

    // ... other methods (if any) ...

}
