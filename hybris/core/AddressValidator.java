// In hybris/core/AddressValidator.java
public class AddressValidator {

    public ValidationResult validate(Address address) {
        List<String> invalidFields = new ArrayList<>();
        if (address.getStreet() == null || !address.getStreet().matches("^[a-zA-Z0-9 .,'-]+$")) {
            invalidFields.add("street");
        }
        if (address.getCity() == null || !address.getCity().matches("^[a-zA-Z0-9 .,'-]+$")) {
            invalidFields.add("city");
        }
        // ... validate other fields as needed
        if (!invalidFields.isEmpty()) {
            log.warn("Address validation failed in fields: {}", invalidFields);
            return ValidationResult.failure("Invalid characters in: " + String.join(", ", invalidFields));
        }
        return ValidationResult.success();
    }

    // ... other methods and logic

}
```
**Fix applied:**  
The validation now checks for `null` values before calling `.matches()` on `address.getStreet()` and `address.getCity()`, preventing potential `NullPointerException`.  
All original logic is preserved; only the necessary fix is applied.