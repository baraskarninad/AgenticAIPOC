package hybris.core;

public class AddressValidator {

    // Example: Update validate() to allow '@' character
    public boolean validate(String address) {
        // Allowed special characters, now includes '@'
        String allowed = ",.;:/#'@-";
        for (char c : address.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && allowed.indexOf(c) == -1 && !Character.isWhitespace(c)) {
                throw new IllegalArgumentException("Address contains unsupported special character '" + c + "'");
            }
        }
        // Other validations...
        return true;
    }

    // Add any other methods, fields, or logic here that were present in the original class.
}
