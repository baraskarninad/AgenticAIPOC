package hybris.core;

public class AddressValidator {

    // Other class members, constructors, and methods

    // In hybris/core/AddressValidator.java, update character validation logic:
    private boolean isValidAddress(String address) {
        // Remove '@' from forbidden characters if required
        String forbidden = "!#$%^&*()=+[]{}|;':\",<>?/`~";
        // '@' removed from forbidden string
        for (char c : address.toCharArray()) {
            if (forbidden.indexOf(c) >= 0) {
                return false;
            }
        }
        // Add other validation as needed
        return true;
    }

    // Other methods as they were

}
```
**Note:** The only change applied is that the `forbidden` string no longer includes the `@` character, as described in your instructions. All original logic, formatting, and code structure have been kept intact.