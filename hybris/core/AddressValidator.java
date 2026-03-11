// hybris/core/AddressValidator.java
public class AddressValidator {

    public boolean isAddressValid(String address) {
        // Allow alphanumeric, spaces, dots, hyphens, comma
        String sanitized = address.replaceAll("[^a-zA-Z0-9\\.\\-\\,\\s]", "");
        // Only check for minimum/maximum length, further validation as per business rules
        return sanitized.length() > 5 && sanitized.length() < 120;
    }
    
    // Feedback to user should specify which characters are invalid and suggest correction.
    public String getInvalidCharactersFeedback(String address) {
        // Define regex of allowed characters
        String allowedRegex = "[a-zA-Z0-9\\.\\-\\,\\s]";
        StringBuilder invalidChars = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (!String.valueOf(c).matches(allowedRegex) && invalidChars.indexOf(String.valueOf(c)) == -1) {
                invalidChars.append(c);
            }
        }
        if (invalidChars.length() == 0) {
            return "All characters in your address are valid.";
        } else {
            return "The address contains invalid characters: '" + invalidChars.toString() +
                   "'. Please remove these characters and use only letters, numbers, spaces, dots (.), hyphens (-), or commas (,).";
        }
    }
}
