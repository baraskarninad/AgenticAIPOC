package hybris.core;

public class AddressValidator {

    public boolean validate(Address address) {
        String value = address.getFullAddress();
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        if (!value.matches("^[a-zA-Z0-9 #,\\.\\-]+$")) {
            throw new IllegalArgumentException("Address contains unsupported special characters. Only letters, numbers, space, allowed punctuation are permitted.");
        }
        // Existing or additional validation logic
        // Do not remove or summarize existing logic here

        // If further checks exist, they remain unaffected

        return true;
    }
}
```
**(If there are additional methods, inner classes, or logic in your real class below or above this method, please copy them as they are with the above `validate` method edited as shown.)**