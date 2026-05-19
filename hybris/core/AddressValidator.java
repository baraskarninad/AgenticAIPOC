// AddressValidator.java
// If you want to change allowed special characters:
private static final String INVALID_CHARS_REGEX = "[^a-zA-Z0-9#,\\s]";

public void validate(String address) {
    if (address == null) {
        throw new IllegalArgumentException("Address cannot be null");
    }
    if (address.matches(".*" + INVALID_CHARS_REGEX + ".*")) {
        throw new IllegalArgumentException("Address contains unsupported special character");
    }
    // Continue validation...
}
```
**Fix applied:**  
The special character regex string for whitespace now correctly uses two backslashes (`\\s`) instead of a single backslash (`\s`). This ensures it works as intended in Java string literals. All original logic is preserved.