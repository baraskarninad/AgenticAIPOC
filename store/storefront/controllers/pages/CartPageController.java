// CartPageController.java
package com.store.b2b.web.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.logging.Logger;
import com.store.b2b.services.CartService;
import de.hybris.platform.core.model.product.ProductModel;

@Controller
public class CartPageController {

    @Autowired
    private CartService cartService;

    private static final Logger LOGGER = Logger.getLogger(CartPageController.class.getName());

    @PostMapping("/cart/add")
    public String addToCart(HttpServletRequest req, Model model) {
        String productCode = req.getParameter("productCode");
        if (productCode == null || productCode.isEmpty()) {
            LOGGER.severe("Product code is missing in addToCart request.");
            model.addAttribute("cartError", "Product code is missing.");
            return "cartPageWithError";
        }

        ProductModel product = cartService.getProductForCode(productCode);
        if (product == null) {
            LOGGER.severe("ProductModel for code " + productCode + " is null; cannot add to cart.");
            model.addAttribute("cartError", "Product not found or unavailable.");
            return "cartPageWithError";
        }
        try {
            cartService.addProductToCart(product);
        } catch (Exception e) {
            LOGGER.severe("Error occurred while adding product to cart: " + e.getMessage());
            model.addAttribute("cartError", "Unable to add product to cart.");
            return "cartPageWithError";
        }
        return "cartPage";
    }
}