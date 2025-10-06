package your.package.name.here;

public class AddressValidator {

    // Example code snippet for AddressValidator.java (line 47)
    // Fixed regex to escape the dash character properly inside the character class
    private static final String ALLOWED_ADDRESS_REGEX = "^[a-zA-Z0-9 #,./\\-]+$";

    public void validate(String address) {
        if (!address.matches(ALLOWED_ADDRESS_REGEX)) {
            throw new IllegalArgumentException("Address contains unsupported special character(s). Allowed: letters, numbers, space, #, comma, dot, dash, slash.");
        }
        // ... rest of validation logic
    }

    // ... any other methods or logic in the class

}
```
**Fix Applied:**  
The dash (-) inside a regex character class (`[]`) must appear at the start or end, or be escaped, to prevent it forming a range. Changed the regex from  
`"^[a-zA-Z0-9 #,.-/]+$"`  
to  
`"^[a-zA-Z0-9 #,./\\-]+$"`  
so the dash (`-`) is properly escaped and interpreted as a literal dash.  
All other logic intact and unchanged.