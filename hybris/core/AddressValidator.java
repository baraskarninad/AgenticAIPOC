package storerepo.hybris.core;

public class AddressValidator {

    // Example - Update validation logic to allow '@'
    private static final String ADDRESS_PATTERN = "^[a-zA-Z0-9#\-,@\.\s]+$";

    public void validate(String address) {
        if (!address.matches(ADDRESS_PATTERN)) {
            throw new IllegalArgumentException("Address contains unsupported special characters");
        }
    }

    // other methods and logic of AddressValidator...

}
