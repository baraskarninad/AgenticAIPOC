// hybris/core/AddressValidator.java
public class AddressValidator {
    // Extend UNSUPPORTED_CHARS with all disallowed characters
    private static final String UNSUPPORTED_CHARS = "@#%^&*()=+[]{};:'\",<>/?\\|`~";

    public void validate(String address) {
        if (address != null && address.matches(".*[" + UNSUPPORTED_CHARS + "]+.*")) {
            throw new IllegalArgumentException("Address contains unsupported special characters: '" + UNSUPPORTED_CHARS + "'");
        }
        // existing validation logic...
    }
}
