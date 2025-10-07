package hybris.core;

import java.util.regex.Pattern;

public class AddressValidator {

    // Added '@' character to the allowed pattern as per the fix request
    private static final Pattern ALLOWED_CHARS = Pattern.compile("^[a-zA-Z0-9\\s,\\.\\-@#\\/]+$"); 

    public void validate(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address must not be null");
        }

        validateField(address.getStreet(), "Street");
        validateField(address.getCity(), "City");
        validateField(address.getZip(), "Zip");
        if (address.getAdditionalInfo() != null) {
            validateField(address.getAdditionalInfo(), "Additional Info");
        }
        // Any other address fields or existing validation logic remains unchanged
    }

    private void validateField(String addressField, String fieldName) {
        if (addressField == null || addressField.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " must not be empty");
        }
        if (!ALLOWED_CHARS.matcher(addressField).matches()) {
            throw new IllegalArgumentException(
                "Address contains unsupported special character(s) in '" + fieldName + "': " + addressField +
                ". Allowed characters: letters, numbers, spaces, comma, dot (.), dash (-), @, #, /"
            );
        }
    }

    // Other methods and logic in AddressValidator stay unchanged

    // Presuming an Address class exists with relevant getters. This is just for context.
    public static class Address {
        private String street;
        private String city;
        private String zip;
        private String additionalInfo;

        public Address(String street, String city, String zip, String additionalInfo) {
            this.street = street;
            this.city = city;
            this.zip = zip;
            this.additionalInfo = additionalInfo;
        }

        public String getStreet() {
            return street;
        }

        public String getCity() {
            return city;
        }

        public String getZip() {
            return zip;
        }

        public String getAdditionalInfo() {
            return additionalInfo;
        }
    }
}
```
**Summary of changes:**
- The regular expression now includes `@` as a permitted character. 
- Improved the exception message to clarify which field failed and which characters are permitted.
- All other original logic remains fully intact.