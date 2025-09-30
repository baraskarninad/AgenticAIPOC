package com.store.b2b.facades.populators;

import org.apache.log4j.Logger;

public class StoreProductPricePopulator {
    private static final Logger LOG = Logger.getLogger(StoreProductPricePopulator.class);

    public void populate(final SourceType source, final TargetType target) {
        if (source == null || target == null) {
            LOG.error("Source or Target is null in StoreProductPricePopulator");
            return;
        }
        if (source.getPriceRows() == null) {
            LOG.error("Price rows are null in StoreProductPricePopulator");
            target.setMsrpPrice(null);
            target.setPMATPrice(null);
            return;
        }
        PriceRow msrpPrice = source.getMsrpPrice();
        PriceRow pmatPrice = source.getPMATPrice();
        if (msrpPrice == null) {
            LOG.error("msrpPrice is null");
            target.setMsrpPrice(null);
        } else {
            target.setMsrpPrice(msrpPrice.getValue());
        }
        if (pmatPrice == null) {
            LOG.error("PMATPrice is null");
            target.setPMATPrice(null);
        } else {
            target.setPMATPrice(pmatPrice.getValue());
        }
        // Continue with other populate logic...
    }
}
