// hybris/core/AddressValidator.java
// Existing code (example):
private static final String UNSUPPORTED_CHARS = "#$%^&*()"; // '@' is now allowed

public void validate(Address address) {
    String input = address.getFullAddress();
    for (char c : UNSUPPORTED_CHARS.toCharArray()) {
        if (input.indexOf(c) >= 0) {
            throw new IllegalArgumentException("Address contains unsupported special character '" + c + "'. Allowed characters: letters, numbers, '@', and basic punctuation. Unsupported: # $ % ^ & * ( )");
        }
    }
}
```
**Fix applied:**  
- Removed '@' from UNSUPPORTED_CHARS.
- Updated validation error message to be more user-friendly and to indicate allowed/disallowed characters.  
All original logic is preserved.