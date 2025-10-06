package storerepo.hybris.core;

public class AddressValidator {

    public boolean isValidAddress(String address) {
        // Accept '@' as a valid character in address fields
        String allowedChars = "[a-zA-Z0-9\\s,#@.\\-]+";
        if (address == null || !address.matches(allowedChars)) {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }
        return true;
    }

}
```
**Fix applied:**  
- Escaped the backslash characters in the regular expression for Java string: `\s` ⇒ `\\s`, `-` ⇒ `\\-`  
- Preserved all other original logic and formatting.