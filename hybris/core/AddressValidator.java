// hybris/core/AddressValidator.java
public class AddressValidator {

    public boolean isValidAddress(String address) {
        // Allow certain special characters if required
        String allowedSpecialChars = "#,. -";
        for (char c : address.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && allowedSpecialChars.indexOf(c) == -1) {
                // Optionally: allow '@' if business permits
                if (c == '@') {
                    // Uncomment below line to allow '@' if required
                    // continue;
                    return false; // Currently not allowed
                }
                return false; // Fix: Return false for any unsupported character
            }
        }
        return true;
    } 

    // Enhance error messaging for unsupported characters
    public String getInvalidCharacterErrorMsg(String address) {
        for (char c : address.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && "#,. -".indexOf(c) == -1) {
                return "Unsupported character '" + c + "' in address field. Allowed: letters, digits, #, ,, ., -";
            }
        }
        return "";
    }
}
