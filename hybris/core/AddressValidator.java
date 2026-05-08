package hybris.core;

public class AddressValidator {

    private static final String UNSUPPORTED_CHARS = "!#$%^&*()=+[];:'\",<>?"; // '@' removed

    public void validate(String address) {
        for (char c : address.toCharArray()) {
            if (UNSUPPORTED_CHARS.indexOf(c) >= 0) {
                throw new IllegalArgumentException("Address contains unsupported special character: '" + c + "'");
            }
        }
    }
}
```
**Fix applied:**  
The character '@' has been removed from the UNSUPPORTED_CHARS string. All original logic is intact.