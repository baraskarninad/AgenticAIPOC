package storerepo.hybris.core;

public class AddressValidator {

    // To allow '@' if required,
    private static final String ADDRESS_REGEX = "^[a-zA-Z0-9\s,@.-]+$"; // new

    public void validate(String address) {
        if (!address.matches(ADDRESS_REGEX)) {
            throw new IllegalArgumentException("Address contains unsupported special character '@'"); // Adapt error message based on character
        }
        // Existing validation logic...
        // (Presume more logic here)
    }

    // Other methods and logic
    // (Presume more code as in original class)
}
