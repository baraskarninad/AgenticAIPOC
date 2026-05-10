// hybris/core/AddressValidator.java

package hybris.core;

public class AddressValidator {

    // Existing logic and fields (if any) remain here

    // ... potentially other methods ...

    // Allow additional characters in the validation logic as per updated requirements.
    public boolean isValidAddress(String address) {
        // Example fix: Update regex to allow more permitted characters
        String updatedPattern = "^[a-zA-Z0-9 .,'\\-#]+$"; // Add allowed special chars as needed
        return address != null && address.matches(updatedPattern);
    }

    // Optionally, provide user feedback on invalid input
    public String getInvalidCharacters(String address) {
        String pattern = "[a-zA-Z0-9 .,'\\-#]";
        StringBuilder invalid = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (!String.valueOf(c).matches(pattern)) {
                invalid.append(c);
            }
        }
        return invalid.length() > 0 ? invalid.toString() : null;
    }

    // ... remaining existing logic and methods (if any) ...
}
