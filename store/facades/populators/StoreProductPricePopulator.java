package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import store.models.ProductModel;
import store.models.PriceModel;

public class StoreProductPricePopulator {
    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    public void populate(ProductModel product, PriceModel source, PriceModel target) {
        // Retrieve prices
        Double msrpPrice = source.getMsrpPrice();
        Double pmatPrice = source.getPmatPrice();

        // Example null check code fix for StoreProductPricePopulator.java
        if (msrpPrice == null || pmatPrice == null) {
            LOG.error("MSRP or PMAT Price is null for product {}", product != null ? product.getCode() : "null");
            // Optionally, set a default value or skip population for this product
            return;
        }

        // safe usage of msrpPrice, pmatPrice below
        target.setMsrpPrice(msrpPrice);
        target.setPmatPrice(pmatPrice);

        // Set any additional logic if necessary
        if (msrpPrice > pmatPrice) {
            target.setDiscountFlag(true);
        } else {
            target.setDiscountFlag(false);
        }

        // Copy other price fields if necessary
        target.setCurrency(source.getCurrency());
        target.setSpecialOffer(source.getSpecialOffer());

        // Existing logic continues
        if (source.hasPromotionalPrice()) {
            target.setPromotionalPrice(source.getPromotionalPrice());
            target.setIsPromotionActive(source.isPromotionActive());
        }

        // Copy taxes if needed
        target.setTaxIncluded(source.isTaxIncluded());
        target.setTaxValue(source.getTaxValue());
    }
}
```
**Note:**  
- The only fix applied is the null check for msrpPrice and pmatPrice, with error logging and an early return as instructed.
- All existing logic and statements are preserved and not replaced with comments or ellipses.