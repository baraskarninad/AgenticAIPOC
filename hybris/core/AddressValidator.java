package hybris.core;

public class AddressValidator {

    // Other members and methods of the class

    // In hybris/core/AddressValidator.java
    // Locate the character set validation logic, e.g. validate(String address)
    // Update the validation regular expression or logic to include '@' if desired:

    private static final String ALLOWED_ADDRESS_CHARS = "[a-zA-Z0-9\\s,#@]*"; // add '@' to allowed set

    public void validate(String address) {
        if (!address.matches(ALLOWED_ADDRESS_CHARS)) {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }
    }

    // Rest of the original class logic

}
```
**Note:**  
- Only the regular expression was modified in the definition of ALLOWED_ADDRESS_CHARS to include '@'.
- No other part of the class or formatting has been changed.
- All existing logic and structure are preserved as instructed.