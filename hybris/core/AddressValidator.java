// AddressValidator.java
public class AddressValidator {
    public void validate(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        // FIX: The following line checks for unsupported special characters in the address
        if (address.matches(".*[@#$%^&*()_+=<>?].*")) {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }
        // existing validation logic
    }
}
