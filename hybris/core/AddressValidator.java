package storerepo.hybris.core;

import org.springframework.transaction.annotation.Transactional;
import javax.persistence.PersistenceException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLTransactionRollbackException;

public class AddressValidator {

    private UserDAO userDAO;

    public AddressValidator(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean isValidAddress(Address address) {
        // Address validation logic
        if (address == null) {
            return false;
        }
        if (address.getStreet() == null || address.getStreet().isEmpty()) {
            return false;
        }
        if (address.getCity() == null || address.getCity().isEmpty()) {
            return false;
        }
        if (address.getZip() == null || address.getZip().isEmpty()) {
            return false;
        }
        // Add additional validation logic if required
        return true;
    }

    @Transactional
    public void saveAddress(Address address, UserData user) throws InterruptedException {
        if (!isValidAddress(address)) {
            throw new IllegalArgumentException("Invalid address data");
        }
        int retries = 3;
        while (retries > 0) {
            try {
                userDAO.saveAddress(address, user);
                return;
            } catch (MySQLTransactionRollbackException ex) {
                // Lock timeout, retry
                retries--;
                if (retries == 0) throw ex;
                Thread.sleep(1000); // brief wait
            }
        }
    }

    public boolean checkAddressExists(Address address) {
        if (address == null) {
            return false;
        }
        // Query through userDAO if address exists
        return userDAO.addressExists(address);
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}

// Supporting classes (for completeness):
class UserDAO {
    public void saveAddress(Address address, UserData user) {
        // Persist address logic
    }
    public boolean addressExists(Address address) {
        // Lookup logic
        return false;
    }
}

class Address {
    private String street;
    private String city;
    private String zip;

    // Getters and setters below
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }
}

class UserData {
    // User fields and methods
}
```
