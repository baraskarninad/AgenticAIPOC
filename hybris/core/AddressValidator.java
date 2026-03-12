package hybris.core;

public class AddressValidator {

    // Existing fields and methods...

    public boolean isValid(char c) {
        // Allow only letters, numbers, spaces, and standard punctuation
        return Character.isLetterOrDigit(c) || " #.,-_/\\".indexOf(c) >= 0;
    }

    public void validate(String address) {
        for (char c : address.toCharArray()) {
            if (!isValid(c)) {
                throw new IllegalArgumentException("Address contains unsupported special character '" + c + "'");
            }
        }
        // existing validation logic...
        // (All other lines and logic stay as-is, nothing is removed or replaced)
    }

    // Other methods and logic...
}
