package hybris.core;

public class AddressValidator {

    public boolean isValid(String address) {
        if (address == null) return false;
        // Example: Allow a broader set of valid characters (alphanumeric, whitespace, common punctuation)
        String regex = "^[\\w\\s\\-.,/\\\\#()]+$";
        return address.matches(regex);
    }

    // Before validation, sanitize/trim input
    public String sanitizeAddress(String input) {
        return input != null ? input.trim().replaceAll("[\\p{C}]","") : "";
    }

    // Usage example:
    public void validateAddress(String address) throws ValidationException {
        String sanitized = sanitizeAddress(address);
        if (!isValid(sanitized)) {
            // Provide clear feedback to user about allowed formats
            throw new ValidationException("Address contains invalid characters. Allowed: letters, numbers, spaces, and common punctuation.");
        }
    }

}
