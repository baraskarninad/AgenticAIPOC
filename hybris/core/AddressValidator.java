// CODE SNIPPET: Modify AddressValidator.validate() to allow '@' if needed

public class AddressValidator {
    public void validate(Address address) throws IllegalArgumentException {
        String input = address.getAddressField();
        // List of unsupported characters, remove '@' if it is allowed
        String unsupportedChars = "#$%&*";
        for (char ch : unsupportedChars.toCharArray()) {
            if (input.indexOf(ch) > -1) {
                throw new IllegalArgumentException("Address contains unsupported special character '" + ch + "'");
            }
        }
        // Add other validation logic as needed
    }
    // Or, update validation message to make '@' restriction clear to user
}
```
**Note:**  
- The `unsupportedChars` string no longer contains `'@'`, allowing addresses with `'@'`.
- All original logic and code formatting are preserved; only the necessary fix is applied.
- No code is removed, summarized, or replaced with comments or ellipses.