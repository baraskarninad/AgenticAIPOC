package de.hybris.platform.acceleratorstorefrontcommons.controllers.pages;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartPageController {
    private static final Logger LOG = Logger.getLogger(CartPageController.class);

    @Autowired
    private ProductService productService;

    // ... other fields and methods

    @RequestMapping(value = "/cart/add", method = RequestMethod.POST)
    public String addToCart(@RequestParam("productCode") String code, Model model) {
        ProductModel product = productService.getProductForCode(code);
        if (product == null) {
            model.addAttribute("errorMessage", "Product not found for code: " + code);
            LOG.error("Attempted to add non-existent product to cart: " + code);
            return "redirect:/cart?error=productNotFound";
        }
        String productCode = product.getCode();
        // ... rest of logic to add to cart
        return "redirect:/cart";
    }
}