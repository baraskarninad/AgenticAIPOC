// hybris/core/AddressValidator.java
public class AddressValidator {

    public boolean isValid(Address address) {
        if (address == null) return false;
        String streetRegex = "^[a-zA-Z0-9\\s,.-]+$";
        String cityRegex = "^[a-zA-Z\\s.-]+$";
        String postalCodeRegex = "^[a-zA-Z0-9\\s-]+$";

        if (address.getStreet() == null || !address.getStreet().matches(streetRegex)) {
            return false;
        }
        if (address.getCity() == null || !address.getCity().matches(cityRegex)) {
            return false;
        }
        if (address.getPostalCode() == null || !address.getPostalCode().matches(postalCodeRegex)) {
            return false;
        }
        // Add more checks as needed

        return true;
    }
}
