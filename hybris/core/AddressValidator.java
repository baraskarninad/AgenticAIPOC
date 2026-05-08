// In hybris/core/AddressValidator.java
// Add/Update validation logic to check allowed characters and provide meaningful errors
public void validate(String address) {
    if (address == null || address.isEmpty()) {
        throw new IllegalArgumentException("Address cannot be empty");
    }
    // Allow letters, digits, common punctuation (customize regex as needed)
    if (!address.matches("[a-zA-Z0-9 ,.-/#]+")) {
        throw new IllegalArgumentException(
            "Address contains unsupported special characters. Allowed characters: letters, digits, spaces, ',', '.', '-', '/', and '#'."
        );
    }
}
// Consider updating the error message to instruct users on allowed characters.
```
