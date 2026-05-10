package com.storerepo.hybris.core;

public class AddressValidator {

    // Example update to character validation logic inside AddressValidator.java
    private static final String SUPPORTED_ADDRESS_REGEX = "^[\\w\\s,@#.-]*$"; // add @ if allowed

    public static void validateAddress(String address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }

        if (!address.matches(SUPPORTED_ADDRESS_REGEX)) {
            throw new IllegalArgumentException("Address contains unsupported special character");
        }

        // Additional validation logic (ZIP, length, etc.)
        if (address.length() < 10 || address.length() > 255) {
            throw new IllegalArgumentException("Address length is out of supported range");
        }

        // Could include more validation rules below
    }

    // Other methods related to address validation
    public static boolean isPincodeValid(String pincode) {
        if (pincode == null) {
            return false;
        }
        // Assuming Indian PIN code format: 6 digit number
        return pincode.matches("^[1-9][0-9]{5}$");
    }

    public static boolean isCountrySupported(String country) {
        if (country == null) {
            return false;
        }
        // Allowing only a fixed set of country codes for delivery
        String[] supportedCountries = {"IN", "US", "GB", "CA"};
        for (String sc : supportedCountries) {
            if (country.equalsIgnoreCase(sc)) {
                return true;
            }
        }
        return false;
    }

    // Sample usage method
    public static void main(String[] args) {
        String address = "123 Main St., Apt #5, Bangalore@560001";
        try {
            validateAddress(address);
            System.out.println("Valid address.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Validation failed: " + ex.getMessage());
        }

        String pincode = "560001";
        System.out.println("Pincode valid: " + isPincodeValid(pincode));

        String country = "IN";
        System.out.println("Country supported: " + isCountrySupported(country));
    }
}
