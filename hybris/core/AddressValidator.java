package storerepo.hybris.core;

public class AddressValidator {

    // AddressValidator.java snippet
    // Remove '@' from unsupported chars if valid
    private static final String UNSUPPORTED_CHARS = "!$%^&*()[]{};:,<>?\"=|";

    public boolean validate(String address) {
        for (char ch : UNSUPPORTED_CHARS.toCharArray()) {
            if (address.indexOf(ch) >= 0) {
               throw new IllegalArgumentException("Address contains unsupported special character '" + ch + "'");
            }
        }
        // Additional validation logic...
        return true;
    }

    // other methods and logic (if any) remain unchanged

}
```
**Fix applied:**  
The list UNSUPPORTED_CHARS now does **not** include the '@' character, as requested, preserving all other code and logic.