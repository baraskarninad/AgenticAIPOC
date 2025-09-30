package com.client.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpSession;

import com.client.facades.cart.ClientCartFacade;
import com.client.exceptions.CartConversionException;

@RestController
@RequestMapping("/cart")
public class CartPageController {

    private static final Logger LOG = LoggerFactory.getLogger(CartPageController.class);

    private final ClientCartFacade clientCartFacade;

    @Autowired
    public CartPageController(ClientCartFacade clientCartFacade) {
        this.clientCartFacade = clientCartFacade;
    }

    /**
     * Convert or save cart by cart code.
     */
    @PostMapping("/convert")
    public ResponseEntity<?> convertSavedCart(@RequestParam("cartCode") String cartCode, HttpSession session) {
        if (cartCode == null || cartCode.trim().isEmpty()) {
            LOG.warn("Received empty cartCode for conversion request.");
            return ResponseEntity.badRequest().body("Cart code must not be empty.");
        }

        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            LOG.error("No user session found during cart conversion for cartCode: {}", cartCode);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User session missing.");
        }

        try {
            boolean converted = clientCartFacade.convertCart(cartCode, userId);
            if (converted) {
                LOG.info("Cart successfully converted for cartCode: {}", cartCode);
                return ResponseEntity.ok("Cart conversion successful.");
            } else {
                LOG.error("Cart conversion failed for cartCode: {}", cartCode);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to convert cart.");
            }
        } catch (CartConversionException ex) {
            LOG.error("Exception during cart conversion for cartCode: {}. Error: {}", cartCode, ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Cart conversion failed: " + ex.getMessage());
        } catch (Exception ex) {
            LOG.error("Unexpected error during cart conversion for cartCode: {}. Error: {}", cartCode, ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Unexpected error: " + ex.getMessage());
        }
    }
}
