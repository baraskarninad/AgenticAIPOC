package hybris.core;

public class AddressValidator {

    private static final String UNSUPPORTED_CHARACTERS = "@"; // add other unsupported characters

    // Existing logic...

    public boolean validate(String address) {
        for (char c : UNSUPPORTED_CHARACTERS.toCharArray()) {
            if (address.contains(String.valueOf(c))) {
                // Throw or return error with a user-friendly message
                throw new IllegalArgumentException("Address contains unsupported character: " + c);
            }
        }
        // Proceed with other validations...
        // Existing validation logic goes here
        return true;
    }

    // Existing methods, constructors, etc.

}
