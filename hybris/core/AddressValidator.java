public class AddressValidator {
    public boolean validate(String address) {
        String sanitized = address.replaceAll("[^a-zA-Z0-9\\s,.:-]", ""); // Accept only allowed characters
        if (!sanitized.equals(address)) {
            // log or inform user of sanitization
        }
        // continue with existing validation logic
        return baseValidation(sanitized);
    }
    private boolean baseValidation(String addr) {
        // ... original validation logic ...
    }
}
```
**Fix applied:**  
The regular expression in `replaceAll("[^a-zA-Z0-9\s,.:-]", "")` is corrected to `replaceAll("[^a-zA-Z0-9\\s,.:-]", "")` by escaping the `\s` for proper Java string literal interpretation.  
All other code remains intact.