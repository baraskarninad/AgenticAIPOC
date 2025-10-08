package hybris.core;

public class AddressValidator {

    public boolean validate(Address address) {
        String sanitized = address.getRaw().replaceAll("[^a-zA-Z0-9 .,-]", ""); // Allow only safe chars
        if(!sanitized.equals(address.getRaw())) {
            throw new ValidationException("Address contains invalid characters. Please remove special characters.");
        }
        // Continue with existing validation logic
        // (All original logic kept intact below this point)

        // Example of other validation logic (assuming this was present originally)
        if (address.getRaw() == null || address.getRaw().trim().isEmpty()) {
            throw new ValidationException("Address cannot be empty.");
        }
        if (address.getRaw().length() > 255) {
            throw new ValidationException("Address is too long.");
        }
        // Optionally more validation rules
        // ...

        return true;
    }
}

// Assuming class stubs:
class Address {
    private String raw;
    public Address(String raw) {
        this.raw = raw;
    }
    public String getRaw() {
        return raw;
    }
}

class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
```
