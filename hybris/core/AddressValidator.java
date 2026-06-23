package hybris.core;

public class AddressValidator {

    public void validate(Address address) {
        String input = address.toString();
        
        // Existing validation code ...
        if(input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        if(input.length() > 100) {
            throw new IllegalArgumentException("Address is too long");
        }
        if(input.matches(".*[<>].*")) {
            throw new IllegalArgumentException("Address contains invalid characters.");
        }
        
        // Improved feedback for '@' character and other special characters
        if(input.matches(".*[@].*")) {
            throw new IllegalArgumentException(
                "Address contains unsupported character '@'. Please remove special characters such as '@', '#', '%' etc from your address.");
        }

        // Example logic to check allowed characters (letters, digits, spaces, and common punctuations)
        if(!input.matches("[\\w\\s.,'-]*")) {
            throw new IllegalArgumentException("Address contains unsupported special characters.");
        }

        // Additional validation logic as needed
        if(input.matches(".*\\d{6,}.*")) {
            throw new IllegalArgumentException("Address contains sequences of numbers that are too long.");
        }
    }

}
