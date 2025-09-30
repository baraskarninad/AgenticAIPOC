package com.yourcompany.storefront.controllers;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.product.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class CartPageController {
    private static final Logger LOG = LoggerFactory.getLogger(CartPageController.class);

    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam("productCode") String productCode,
                            @RequestParam("qty") int qty,
                            RedirectAttributes redirectAttributes) {
        if (StringUtils.isBlank(productCode)) {
            LOG.error("Attempt to add to cart without a product code");
            redirectAttributes.addFlashAttribute("error", "No product code provided");
            return "redirect:/cart";
        }
        ProductModel product = productService.getProductForCode(productCode);
        if (product == null) {
            LOG.error("No ProductModel found for code [{}]", productCode);
            redirectAttributes.addFlashAttribute("error", "Product not found: " + productCode);
            return "redirect:/cart";
        }
        try {
            cartService.addToCart(product, qty);
        } catch (Exception e) {
            LOG.error("Exception occurred while adding product [{}] to cart", productCode, e);
            redirectAttributes.addFlashAttribute("error", "Failed to add product to cart");
            return "redirect:/cart";
        }
        return "redirect:/cart";
    }
}
