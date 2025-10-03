package hybris.core;

public class AddressValidator {

    public void validate(String address) {
        // Old validation - strict, e.g., only alphanumeric + limited special chars
        // New: Permit common address chars (e.g., #, ',', '.', '-', etc.), but still filter scripts or invalid input
        if(address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address is required.");
        }
        // Fix: Escape '-' properly and move it to the end or start of the character class, and escape '.'
        if (!address.matches("^[a-zA-Z0-9 #,./\\-]+$") ) {
            throw new IllegalArgumentException("Address contains unsupported special characters. Allowed are: letters, numbers, space, #, comma, dot, dash, slash.");
        }
        // other logic...
    }

}
```
