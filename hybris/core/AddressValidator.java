// Example: Update validation logic to provide clearer errors or allow '@' if required
public class AddressValidator {
    private boolean allowAtSymbol = false; // New flag to control '@' allowance

    /**
     * Allows '@' symbol in address validation if set to true.
     */
    public void setAllowAtSymbol(boolean allow) {
        this.allowAtSymbol = allow;
    }

    public void validate(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty.");
        }
        // Disallow unsupported/illegal characters
        String disallowed;
        if (allowAtSymbol) {
            disallowed = "[^a-zA-Z0-9\\s.,#@-]";
        } else {
            disallowed = "[^a-zA-Z0-9\\s.,#-]";
        }
        if (address.matches(".*" + disallowed + ".*")) {
            throw new IllegalArgumentException("Address contains unsupported special character: " + extractDisallowed(address));
        }
        // Optionally... allow '@' if business approves:
        // String disallowed = "[^a-zA-Z0-9\s.,#@-]";
    }
    private String extractDisallowed(String address) {
        String allowedChars = " .,#-";
        if (allowAtSymbol) {
            allowedChars += "@";
        }
        for (char c : address.toCharArray()) {
            if (!(Character.isLetterOrDigit(c) || allowedChars.indexOf(c) >= 0)) {
                return String.valueOf(c);
            }
        }
        return "?";
    }
}
```
