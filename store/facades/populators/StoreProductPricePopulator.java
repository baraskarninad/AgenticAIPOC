package store.facades.populators;

import org.apache.log4j.Logger;

public class StoreProductPricePopulator implements Populator<SourceProduct, TargetProduct> {

    private static final Logger LOG = Logger.getLogger(StoreProductPricePopulator.class);

    @Override
    public void populate(final SourceProduct source, final TargetProduct target) {
        if(source.getMsrpPrice() == null || source.getPmatPrice() == null) {
            LOG.error("msrpPrice or PMATPrice price are null. Check data ingestion or ERP integration.");
            // Optional: set default value or skip processing
            // FIX: Set default values instead of just returning
            target.setMsrpPrice(source.getMsrpPrice() != null ? source.getMsrpPrice() : BigDecimal.ZERO);
            target.setPmatPrice(source.getPmatPrice() != null ? source.getPmatPrice() : BigDecimal.ZERO);
            return;
        }
        target.setMsrpPrice(source.getMsrpPrice());
        target.setPmatPrice(source.getPmatPrice());
        // ... rest of the population logic
    }
}
```
