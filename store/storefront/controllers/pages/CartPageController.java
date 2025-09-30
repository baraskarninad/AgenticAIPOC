package store.storefront.controllers.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/cart")
public class CartPageController {

    private static final Logger LOG = LoggerFactory.getLogger(CartPageController.class);

    private final ProductService productService;
    private final CartService cartService;

    public CartPageController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam String productId, Model model, @RequestParam(required = false) Integer quantity) {
        ProductModel product = productService.getProductById(productId);
        if (product == null) {
            LOG.error("Product not found for productId: {}", productId);
            model.addAttribute("errorMessage", "Product not found.");
            return "errorPage";
        }
        try {
            cartService.addProductToCart(product, quantity);
        } catch (Exception ex) {
            LOG.error("Error occurred while adding product to cart", ex);
            model.addAttribute("errorMessage", "An error occurred while adding the product to the cart.");
            return "errorPage";
        }
        return "redirect:/cart";
    }
}