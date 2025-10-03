// hybris/core/AddressValidator.java
package hybris.core;

public class AddressValidator {

    public boolean isValid(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address must not be null");
        }
        String value = address.getValue();
        if (value == null || value.matches(".*[@].*")) {
            throw new IllegalArgumentException("Address contains unsupported special character '@'");
        }
        // Existing validation logic...
        return true;
    }
}
```
