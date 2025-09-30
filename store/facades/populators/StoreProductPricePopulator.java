package com.store.b2b.facades.populators;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StoreProductPricePopulator {

    private static final Logger LOG = LogManager.getLogger(StoreProductPricePopulator.class);

    public void populate(ProductModel source, ProductData target) {
        List<PriceRowModel> priceRows = source.getPriceRows();
        if (priceRows == null || priceRows.isEmpty()) {
            LOG.warn("Price rows are null or empty in StoreProductPricePopulator for Product: " + source.getCode());
            target.setMsrpPrice(null);  // Or some default value/behavior
            target.setPmatPrice(null);
            return;
        }

        Double msrpPrice = null;
        Double pmatPrice = null;

        for (PriceRowModel priceRow : priceRows) {
            if (priceRow.getType().equals(PriceType.MSRP)) {
                msrpPrice = priceRow.getPrice();
            }
            if (priceRow.getType().equals(PriceType.PMAT)) {
                pmatPrice = priceRow.getPrice();
            }
        }

        if(msrpPrice == null || pmatPrice == null) {
            LOG.warn("msrpPrice or PMATPrice price are null for product: " + source.getCode());
        }

        target.setMsrpPrice(msrpPrice);
        target.setPmatPrice(pmatPrice);
    }
}