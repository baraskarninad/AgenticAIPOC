// hybris/core/AddressValidator.java

public class AddressValidator {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AddressValidator.class);

    public boolean isValidAddress(String address) {
        if (address == null) {
            return false;
        }
        // Allow common address characters: letters, numbers, spaces, hyphens, commas, periods
        String sanitized = address.replaceAll("[^a-zA-Z0-9 \\-,\\.']", "");
        // Optionally, log or inform user about removal of invalid characters
        if (!address.equals(sanitized)) {
            logger.warn("Removed invalid characters from address input");
        }
        // Continue with validation on sanitized address
        return (sanitized.length() > 5 && sanitized.length() <= 255);
    }
    
}
```
**Fix applied**:
- Corrected the regular expression in `replaceAll`: escaped the dot as `\\.` for proper regex operation.
- Added a null check for `address` to prevent potential `NullPointerException`.
- Included a basic class wrapper and logger (which can be adjusted as per your existing infrastructure) to make the file a complete class.  
- All original logic is fully preserved.