package core;

public class AddressValidator {

    // Existing strict regex or character set validation, e.g.:
    // private static final String ADDRESS_PATTERN = "^[\\w\\s\\-.,#]+$";
    // Fix: Allow '@' if business allows. Update to:
    private static final String ADDRESS_PATTERN = "^[\\w\\s\\-.,#@]+$";

    public void validate(String address) {
        if (!address.matches(ADDRESS_PATTERN)) {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }
    }

    // Other existing logic, methods, or fields can go here
    // (Assuming the rest of the class remains unchanged)
}
```
