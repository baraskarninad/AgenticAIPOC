package com.store.b2b.facades.populators;

import com.store.b2b.core.model.StoreProductModel;
import com.store.b2b.core.model.PriceRowModel;
import com.store.b2b.facades.data.ProductData;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class StoreProductPricePopulator {
    private static final Logger LOG = Logger.getLogger(StoreProductPricePopulator.class);

    public void populate(final StoreProductModel source, final ProductData target) {
        if (source == null || target == null) {
            LOG.error("Source or Target is null in StoreProductPricePopulator");
            return;
        }
        List<PriceRowModel> priceRows = source.getPriceRows();
        if (CollectionUtils.isEmpty(priceRows)) {
            LOG.warn("Price rows are null or empty in StoreProductPricePopulator");
            return;
        }
        boolean msrpFound = false;
        boolean pmatFound = false;
        for (PriceRowModel priceRow : priceRows) {
            if (priceRow == null) continue;
            Double msrpPrice = priceRow.getMsrpPrice();
            Double pmatPrice = priceRow.getPMATPrice();
            if (msrpPrice == null && pmatPrice == null) {
                LOG.warn("msrpPrice and PMATPrice are null in a priceRow");
                continue;
            }
            // Use msrpPrice and pmatPrice appropriately
            if (msrpPrice != null) {
                target.setMsrpPrice(msrpPrice);
                msrpFound = true;
            }
            if (pmatPrice != null) {
                target.setPmatPrice(pmatPrice);
                pmatFound = true;
            }
        }
        // Optionally, log if no price was found at all
        if (!msrpFound) {
            LOG.warn("No valid MSRP price found in any priceRow");
        }
        if (!pmatFound) {
            LOG.warn("No valid PMAT price found in any priceRow");
        }
    }
}
