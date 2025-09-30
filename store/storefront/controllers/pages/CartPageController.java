package store.storefront.controllers.pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/cart")
public class CartPageController {

    // Assume addressValidator is autowired or injected appropriately
    private final AddressValidator addressValidator;

    public CartPageController(AddressValidator addressValidator) {
        this.addressValidator = addressValidator;
    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public String addAddress(@ModelAttribute AddressForm addressForm, Model model) {
        if (addressForm == null || addressForm.getAddress() == null) {
            model.addAttribute("error", "Address details are missing.");
            return "cart/addressError";
        }
        try {
            ValidationResult result = addressValidator.validate(addressForm.getAddress());
            if (!result.isValid()) {
                model.addAttribute("error", result.getErrorMessage());
                return "cart/addressError";
            }
            // ... continue processing
        } catch (Exception ex) {
            model.addAttribute("error", "Address validation error: " + ex.getMessage());
            return "cart/addressError";
        }
        // ... rest of method
        return "cart/success";
    }

    // ... other controller methods
}
