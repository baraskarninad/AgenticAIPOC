package hybris.core;

import java.util.regex.Pattern;

public class AddressValidator {

    // In hybris/core/AddressValidator.java
    private static final Pattern ALLOWED_CHARS = Pattern.compile("^[a-zA-Z0-9 .,#\\-'/&()]+$");

    public void validate(Address address) {
        String addr = address.getFullAddress(); // or appropriate field(s)
        if (addr == null || !ALLOWED_CHARS.matcher(addr).matches()) {
            throw new IllegalArgumentException("Address contains unsupported special character. Allowed: letters, numbers, space, . , # - ' / & ( )");
        }
        // existing validation logic
    }
}
```
**Fix applied:**  
The original regex string `"^[a-zA-Z0-9 .,#\-'/&()]+$"` was not escaping the backslash for `\-` in a Java string, which is required. The fix is to double the backslash: `"\\-"`.  
Now the pattern compiles and matches the dash (`-`) character as intended.  
All other logic and formatting remain unchanged.