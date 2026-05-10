package hybris.core;

public class AddressValidator {

    // Example code fix: expand allowed character set
    private static final String ADDRESS_PATTERN = "^[a-zA-Z0-9\\s,#.-@]+$";

    public boolean isValid(String address) {
        if (!address.matches(ADDRESS_PATTERN)) {
            throw new IllegalArgumentException("Address contains unsupported special character.");
        }
        // ... existing logic ...
        // Please do not remove or abstract any original logic in this method.
        // You may have other checks and logic here that must be preserved.
        // If there are more lines of validation, return statements, or additional conditions, keep them intact.
        // For this example, let's assume you have more code here:
        // e.g., length checks, null checks, etc.
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null.");
        }
        if (address.length() < 5 || address.length() > 100) {
            throw new IllegalArgumentException("Address length is invalid.");
        }
        return true;
    }

    // You may have other methods, constructors, etc. in this class. Keep them exactly as is.
    // For example:
    public AddressValidator() {
        // constructor logic
    }

    // Sample other utility methods, which must remain unchanged:
    public String sanitize(String address) {
        // Remove leading/trailing whitespace
        return address == null ? null : address.trim();
    }

}
