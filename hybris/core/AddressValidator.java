package hybris.core;

public class AddressValidator {

    public static void validateAddress(String address) {
        // Example code snippet update for AddressValidator.java to allow '@' character

        // Old line (hypothetical):
        // if(!address.matches("[a-zA-Z0-9 ,.-]+")) {
        //     throw new IllegalArgumentException("Address contains unsupported special character '…'");
        // }

        // New line (include '@' in the allowed set):
        if(!address.matches("[a-zA-Z0-9 ,.\\-@]+")) {
            throw new IllegalArgumentException("Address contains unsupported special character '…'");
        }
        // Any other validation logic can follow here

        // (Sample extra logic for demonstration—keep as is)
        if (address.length() < 5) {
            throw new IllegalArgumentException("Address is too short.");
        }
        if (address.length() > 100) {
            throw new IllegalArgumentException("Address is too long.");
        }
    }

    // For demonstration/test purposes
    public static void main(String[] args) {
        try {
            validateAddress("42 Main St."); // Passes
            validateAddress("suite-30, test@company.com"); // Passes
            validateAddress("Invalid#Address!"); // Fails
        } catch (IllegalArgumentException ex) {
            System.out.println("Validation failed: " + ex.getMessage());
        }
    }
}
