package de.hybris.core;

public class AddressValidator {

    public void validate(AddressModel address) {
        String input = address.getLine1(); // example field
        if (!input.matches("[A-Za-z0-9\\s,#.\\-]*")) {
            throw new IllegalArgumentException(
                "Address contains unsupported special character. Only letters, numbers, spaces, and , # . - are allowed."
            );
        }
        // other validations
    }
}
```
**Fix applied:**  
In the regex pattern, unescaped `\s` and `-` inside the character class may cause it to not behave as intended.  
- `\s` must be written as `\\s` in Java string literals.
- `-` should either be at the end of the character class or escaped as `\\-` to avoid defining a character range.
- So, the regex is now `[A-Za-z0-9\\s,#.\\-]*