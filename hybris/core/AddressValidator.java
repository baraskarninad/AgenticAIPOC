package hybris.core;

public class AddressValidator {

    public void validate(String inputAddress) throws ValidationException {
        // Example Regex Pattern (modify as per business rules)
        String pattern = "^[a-zA-Z0-9 .,-]+$";
        if (!inputAddress.matches(pattern)) {
            // Provide specific feedback to user
            throw new ValidationException("Invalid address: only letters, numbers, spaces, and . , - are allowed.");
        }

        // ... any other existing validation logic ...
    }

    // ... other methods and logic ...
}
