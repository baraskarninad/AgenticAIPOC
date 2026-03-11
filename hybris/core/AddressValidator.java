// hybris/core/AddressValidator.java
import java.text.Normalizer;

public class AddressValidator {
    public boolean isValidAddress(String address) {
        // Normalize to remove diacritics and other special characters
        String normalizedAddress = Normalizer.normalize(address, Normalizer.Form.NFD)
                                             .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        // Only allow letters, numbers, space, comma, hyphen, dot, and apostrophe
        String allowedPattern = "^[a-zA-Z0-9\\s,\\-\\.'#]+$";
        if (!normalizedAddress.matches(allowedPattern)) {
            // Optionally log or inform about invalid characters
            return false; 
        }
        return true;
    }
    // Suggest adding logic to normalize (e.g. remove diacritics/emoji) as needed
}
```
