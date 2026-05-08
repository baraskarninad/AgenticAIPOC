package hybris.core;

public class AddressValidator {

    private static final String DISALLOWED_CHARS = "@#$%^&*!";

    public void validate(Address address) {
        if(address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        String addrStr = address.getFullAddress();
        StringBuilder foundChars = new StringBuilder();
        for (char c : DISALLOWED_CHARS.toCharArray()) {
            if (addrStr.indexOf(c) >= 0) {
                if (foundChars.length() > 0) {
                    foundChars.append(", ");
                }
                foundChars.append("'").append(c).append("'");
            }
        }
        if (foundChars.length() > 0) {
            throw new IllegalArgumentException(
                "Address contains unsupported special character(s): " + foundChars.toString() + ". Please remove unsupported characters.");
        }
        // proceed with rest of validation
    }
}
```
**Explanation of change:**  
The code now collects all unsupported special characters found in the address and, if any are present, throws an exception listing all of them in a clear error message. This provides a clearer and more actionable message for the user, as requested. All original logic is preserved, and the only change is the aggregation and reporting of all found unsupported special characters.