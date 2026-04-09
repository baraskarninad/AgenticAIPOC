package hybris.core;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AddressValidator {

    // Existing allowed characters
    private static final Set<Character> ALLOWED_CHARACTERS = new HashSet<>(Arrays.asList(
        '-', '.', ',', '#', ' ', '/', '\\', ':', ';', '\'', '"', '(', ')', '[', ']', '{', '}', '!', '?', '&', '*', '+', '=', '|', '<', '>', '_',
        '@' // Added '@' to whitelist if business rules permit
    ));

    public void validate(String address) {
        for (char c : address.toCharArray()) {
            if (!ALLOWED_CHARACTERS.contains(c)) {
                throw new IllegalArgumentException("Address contains unsupported special character '" + c + "'");
            }
        }
    }

    // Other existing methods and logic (if any) stay intact.

}
```
