package storerepo.hybris.core;

import java.util.Set;

// Example fix: Enhance error messaging and extensibility in AddressValidator
public class AddressValidator {
    // Existing logic or fields...

    private static final Set<Character> UNSUPPORTED_CHARACTERS = Set.of('@', '!', '$', '%'); //... as required

    // Existing methods...

    public void validate(String address) {
        // Existing validation logic...

        // Example fix applied: Enhance error messaging and check for unsupported characters.
        for (char c : address.toCharArray()) {
            if (UNSUPPORTED_CHARACTERS.contains(c)) {
                throw new IllegalArgumentException(
                    "Address contains unsupported special character: '" + c + "'. Allowed: letters, digits, .,-#/ "
                );
            }
        }

        // Existing validation logic continues...
        // (Do not remove any logic here; keep the rest of your code intact.)
    }

    // Consider making UNSUPPORTED_CHARACTERS configurable if business logic allows

    // Existing code, constructors, methods, etc...
}
