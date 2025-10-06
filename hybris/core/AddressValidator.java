package hybris.core;

import java.util.regex.Pattern;

public class AddressValidator {

    // In hybris/core/AddressValidator.java
    private static final Pattern ALLOWED_ADDRESS_PATTERN = Pattern.compile("^[A-Za-z0-9 ,.\\-#\\/]+$");

    public void validate(String address) {
        if (!ALLOWED_ADDRESS_PATTERN.matcher(address).matches()) {
            throw new IllegalArgumentException("Address contains unsupported special characters. Only letters, numbers, space and , . - # / are allowed.");
        }
        // existing validation logic
    }

    // other methods and logic (if any)
}
```
**Fix applied:**  
The dash (`-`) and forward slash (`/`) in the regex have been escaped (`\\-` and `\\/`) to ensure they are correctly interpreted as literals inside the character class, fixing unintended regex behavior. All other logic remains unchanged as requested.