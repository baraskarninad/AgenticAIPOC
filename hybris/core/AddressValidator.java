// hybris/core/AddressValidator.java

public class AddressValidator {

    // Existing constructor and fields (if any)
    
    public boolean isValid(String address) {
        // Remove unsupported special characters (example: '@')
        String sanitized = address.replaceAll("[@]", "");
        // Proceed with validation logic
        return originalValidationLogic(sanitized);
    }

    // Alternatively, show user-friendly error about allowed characters
    public String getValidationError(String address) {
        if (address.contains("@")) {
            return "Address cannot contain the '@' character.";
        }
        // ... other checks
        return null;
    }

    // Original validation logic
    private boolean originalValidationLogic(String address) {
        // Existing validation logic
        // For example:
        if (address == null || address.isEmpty()) {
            return false;
        }
        // Other validation rules
        // (Keep all existing logic intact)
        return true;
    }
    
    // Any other methods and logic
}
