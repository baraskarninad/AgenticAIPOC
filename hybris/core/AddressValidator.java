// In hybris/core/AddressValidator.java
package hybris.core;

import java.util.regex.Pattern;

public class AddressValidator {
    // Fix: Make supported characters configurable by allowing '@' if business allows
    // Updated regex pattern to include '@'
    private static final Pattern VALID_ADDRESS_PATTERN = Pattern.compile("^[A-Za-z0-9 ,#&.'/@-]+$", Pattern.UNICODE_CASE);

    public void validate(String address) {
        if (!VALID_ADDRESS_PATTERN.matcher(address).matches()) {
            throw new IllegalArgumentException("Address contains unsupported special character.");
        }
    }

    // Optionally, make the supported characters configurable or alert users for specific characters, and update the regex if business allows '@' or other symbols.
}
```
**Fix applied:**  
The regex pattern `VALID_ADDRESS_PATTERN` now allows the `@` symbol, as per your optional instruction for business requirements.  
All original logic is preserved, only the necessary fix is applied.