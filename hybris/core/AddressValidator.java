// hybris/core/AddressValidator.java
public class AddressValidator {

    public boolean validateAddress(String address) {
        // Accept only letters, digits, spaces, hyphens, periods, commas
        String pattern = "^[a-zA-Z0-9\\s\\-\\.,]+$";
        if (!address.matches(pattern)) {
            // Optionally: provide feedback to UI or caller
            return false;
        }
        return true;
    }

    // Ensure frontend and backend both use this pattern,
    // and reject or sanitize input containing '@' and other special symbols.
}
```
**Fix Applied:** The regex pattern in `validateAddress` has been properly escaped for Java string literals, changing `\s` to `\\s`, `\-` to `\\-`, and so on.  
All other original logic and formatting are preserved.