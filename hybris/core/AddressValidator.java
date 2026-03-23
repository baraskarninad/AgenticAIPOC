package hybris.core;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AddressValidator {

    // Removed '@' from the unsupported characters set to permit it if business requirements allow it.
    private static final Set<Character> UNSUPPORTED_CHARACTERS = new HashSet<>(Arrays.asList(
        '#', '$', '%', '&', '*', '!', '~', '`', '^', '(', ')', '+', '=', '{', '}', '[', ']', '|', '\\', ':', ';', '"', '\'', '<', '>', ',', '?', '/'
        // '@' was removed from this list
    ));

    public void validate(String address) {
        for (char c : address.toCharArray()) {
            if (UNSUPPORTED_CHARACTERS.contains(c)) {
                throw new IllegalArgumentException("Address contains unsupported special character '" + c + "'");
            }
        }
    }

    // You may have other members or methods
}
```
