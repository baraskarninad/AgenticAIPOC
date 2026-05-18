public class AddressValidator {
    public boolean isValid(String address) {
        // Modified regex: allow letters, numbers, spaces, common punctuation.
        return address != null && address.matches("^[a-zA-Z0-9 \-,.#']+$");
    }

    // Add additional error messaging for unsupported characters.
    public String getValidationError(String address) {
        if (address == null) {
            return "Address cannot be null.";
        }
        if (!address.matches("^[a-zA-Z0-9 \-,.#']+$")) {
            return "Address contains unsupported characters. Only letters, numbers, spaces, and - , . # ' are allowed.";
        }
        return null;
    }
}
