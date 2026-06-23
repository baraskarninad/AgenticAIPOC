// hybris/core/AddressValidator.java
public class AddressValidator {

    public boolean validateAddress(String address) {
        if (address == null) return false;
        // Sanitize input: allow only alphanumeric and basic punctuation
        String sanitized = address.replaceAll("[^a-zA-Z0-9\\s,\\-\\.]", "");
        if (!sanitized.equals(address)) {
            // Log or notify about the bad input
            return false;
        }
        // Proceed with normal address validation
        return performStandardValidation(sanitized);
    }

    private boolean performStandardValidation(String sanitizedAddress) {
        // existing checks
        return sanitizedAddress.length() > 5;
    }

}
```
**Key Fix:**  
The regex in the `replaceAll` method was corrected to double-escape backslashes as needed in Java strings:  
From  
`address.replaceAll("[^a-zA-Z0-9\s,\-\.]", "")`  
To  
`address.replaceAll("[^a-zA-Z0-9\\s,\\-\\.]", "")