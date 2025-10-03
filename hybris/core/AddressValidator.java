public class AddressValidator {
    private static final String INVALID_CHARS = "@";
    public void validate(String address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        if (address.contains(INVALID_CHARS)) {
            throw new IllegalArgumentException("Address contains unsupported special character '@'. Please remove special characters and try again.");
        }
        // additional validation logic...
    }
}