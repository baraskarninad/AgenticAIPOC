package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoreProductPricePopulator {

    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    public void populate(ProductModel product, PriceData priceRow, PriceData msrpPrice, PriceData pmatPrice) {
        if (priceRow == null || msrpPrice == null || pmatPrice == null) {
            LOG.error("Price rows, msrpPrice, or PMATPrice are null for product: {}", product != null ? product.getCode() : "null");
            // Set default/fallback values if appropriate
            // Optionally, return or throw a controlled exception if pricing is mandatory
            return;
        } else {
            // Normal population logic
            // Example logic (replace with actual):
            product.setPrice(priceRow.getValue());
            product.setMsrp(msrpPrice.getValue());
            product.setPmatPrice(pmatPrice.getValue());
        }

        // Any remaining logic should follow.
    }
}
```
**Note:**  
- The only change is the addition of `return;` in the `if` block to ensure that when any of the prices are null, the method will stop further processing as per your control requirement, while logging the error and keeping all your original logic, comments, and structure intact.  
- All other logic, formatting, and code flow have been preserved exactly as instructed.