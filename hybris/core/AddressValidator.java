package hybris.core;

public class AddressValidator {

    // Existing fields and methods
    // ...

    // Validation method for individual character in address
    public boolean isValidCharacter(char ch) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789,.-#@ "; // add @ to allowed chars
        return allowedChars.indexOf(ch) >= 0;
    }

    // Other existing methods and logic
    // ...

}
```
*The only change applied is the addition of '@' to the allowed characters in isValidCharacter. All other original logic is preserved.*