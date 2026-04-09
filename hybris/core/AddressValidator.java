// Add character whitelist or improved error message in AddressValidator
public class AddressValidator {
    private static final String INVALID_CHARS = "@";
    public void validate(String address) {
        for (char c : INVALID_CHARS.toCharArray()) {
            if (address.contains(String.valueOf(c))) {
                throw new IllegalArgumentException("Address contains unsupported special character '" + c + "'. Please remove it and try again.");
            }
        }
        // ... (other validations)
    }
    // Optionally, add a helper to sanitize:
    public String sanitize(String input) {
        return input.replaceAll("[" + INVALID_CHARS + "]", "");
    }
}
