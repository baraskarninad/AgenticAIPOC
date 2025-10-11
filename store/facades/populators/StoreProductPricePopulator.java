package store.facades.populators;

import java.math.BigDecimal;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import store.facades.data.StoreProductPriceData;
import store.model.PriceRowModel;
import store.model.ProductModel;
import store.services.ContextInfo;

public class StoreProductPricePopulator {

    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    public void populate(final ProductModel product, final List<PriceRowModel> priceRows, final StoreProductPriceData target, final ContextInfo contextInfo) {
        if (priceRows == null || priceRows.isEmpty()) {
            LOG.error("No price rows found for product {} in context {}", product.getCode(), contextInfo);
            // Optionally set default price or handle gracefully
            target.setMsrpPrice(BigDecimal.ZERO); // Or do not set, depending on business logic
            target.setPmatPrice(BigDecimal.ZERO);
            return;
        }

        // Continue with existing logic to populate msrpPrice, pmatPrice, and any other fields
        BigDecimal msrp = null;
        BigDecimal pmat = null;

        for (PriceRowModel priceRow : priceRows) {
            if ("MSRP".equals(priceRow.getType())) {
                msrp = priceRow.getPrice();
            } else if ("PMAT".equals(priceRow.getType())) {
                pmat = priceRow.getPrice();
            }
            // May contain additional logic for other price types or attributes
        }

        if (msrp != null) {
            target.setMsrpPrice(msrp);
        }
        if (pmat != null) {
            target.setPmatPrice(pmat);
        }

        // Any further population logic (for discounts, taxes, etc.)
        if (!CollectionUtils.isEmpty(priceRows)) {
            for (PriceRowModel priceRow : priceRows) {
                // process other price details as needed per your business logic
                if (priceRow.isDiscounted()) {
                    target.setDiscountPrice(priceRow.getDiscountPrice());
                }
                // Additional logic...
            }
        }

        // Possible additional context-based logic
        if (contextInfo != null && contextInfo.isSpecialRegion()) {
            // Adjust prices based on region, special offers, etc.
            target.applyRegionAdjustment(contextInfo.getRegionCode());
        }
    }
}

```
