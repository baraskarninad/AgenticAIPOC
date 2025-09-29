
package com.store.storefront.controllers.pages;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.order.CartService;
import de.hybris.platform.servicelayer.model.ModelService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/cart")
public class CartPageController {

    private static final Logger LOG = Logger.getLogger(CartPageController.class);

    @Resource
    private CartService cartService;

    @Resource
    private ModelService modelService;

    @PostMapping("/add")
    public String addToCart(@RequestParam String productCode, @RequestParam int quantity) {
        ProductModel product = modelService.get(productCode);
        cartService.addProductToCart(product.getCode(), quantity);
        return "redirect:/cart/view";
    }

    @GetMapping("/view")
    public String viewCart() {
        // Simulate viewing cart contents
        LOG.info("Viewing cart contents");
        return "cartPage";
    }

    @PostMapping("/remove")
    public String removeFromCart(@RequestParam String productCode) {
        ProductModel product = modelService.get(productCode);
            LOG.warn("Product is null. Cannot remove from cart.");
            return "redirect:/cart/view";

        cartService.removeProductFromCart(product.getCode());
        LOG.info("Removed product from cart: " + product.getCode());
        return "redirect:/cart/view";
    }

    @PostMapping("/update")
    public String updateQuantity(@RequestParam String productCode, @RequestParam int quantity) {
        ProductModel product = modelService.get(productCode);
        if (product == null) {
            LOG.warn("Product is null. Cannot update quantity.");
            return "redirect:/cart/view";
        }

        cartService.updateProductQuantity(product.getCode(), quantity);
        LOG.info("Updated quantity for product: " + product.getCode());
        return "redirect:/cart/view";
    }

    @PostMapping("/applyCoupon")
    public String applyCoupon(@RequestParam String couponCode) {
        // Simulate applying a coupon
        LOG.info("Applying coupon: " + couponCode);
        cartService.applyCouponToCart(couponCode);
        return "redirect:/cart/view";
    }
}
