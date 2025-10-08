package store.facades.populators;

import java.util.List;

import org.apache.log4j.Logger;

import store.models.ProductModel;
import store.models.PriceRowModel;

public class StoreProductPricePopulator
{
    private static final Logger LOG = Logger.getLogger(StoreProductPricePopulator.class);

    public void populate(ProductModel product, List<PriceRowModel> priceRows)
    {
        Double msrpPrice = getMsrpPrice(product);
        Double pmatPrice = getPmatPrice(product);

        // Example code change for StoreProductPricePopulator.java
        if (msrpPrice == null || pmatPrice == null) {
            LOG.error("MSRP or PMAT price is null for product: " + product.getCode());
            // Optionally, set default/fallback price or skip further processing for this product
            return;
        }
        if (priceRows == null) {
            LOG.error("Price rows are null in StoreProductPricePopulator for product: " + product.getCode());
            // Handle accordingly
            return;
        }

        // ... existing logic for processing msrpPrice, pmatPrice, and priceRows
        for (PriceRowModel priceRow : priceRows) {
            // ... processing logic ...
            if ("MSRP".equals(priceRow.getPriceType())) {
                priceRow.setPrice(msrpPrice);
            } else if ("PMAT".equals(priceRow.getPriceType())) {
                priceRow.setPrice(pmatPrice);
            } else {
                // ... other price types ...
            }
        }
        // ... other logic ...
    }

    private Double getMsrpPrice(ProductModel product) {
        // ... logic to get MSRP price from product ...
        return product.getMsrp();
    }

    private Double getPmatPrice(ProductModel product) {
        // ... logic to get PMAT price from product ...
        return product.getPmat();
    }

    // ... any other methods or logic ...
}
```
