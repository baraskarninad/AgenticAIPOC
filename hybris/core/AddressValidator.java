// AddressValidator.java
public class AddressValidator {

    public boolean validate(Address address) {
        if (address == null) return false;
        if (address.getStreet() == null || address.getStreet().isEmpty()) return false;
        if (address.getPostalCode() == null || address.getPostalCode().isEmpty()) return false;
        // Add other required validations as appropriate
        return true;
    }
    
}
