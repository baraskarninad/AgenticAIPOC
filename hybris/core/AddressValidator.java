public class AddressValidator {

    // Example snippet for input validation improvement
    public boolean validateAddress(Address address) {
        if(address == null) return false;
        if(containsInvalidChars(address.getStreet()) || containsInvalidChars(address.getCity())) {
            log.warn("Address validation failed due to invalid characters.");
            return false;
        }
        // other validation logic ...
        return true;
    }

    private boolean containsInvalidChars(String input) {
        // Allow letters, numbers, spaces, hyphens, and dots only
        return input != null && !input.matches("[\\w\\s\\-.]+");
    }

    // other methods, variables, etc.

}
