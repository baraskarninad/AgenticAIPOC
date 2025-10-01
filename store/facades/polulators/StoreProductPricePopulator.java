package store.facades.populators;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoreProductPricePopulator {

    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    public void populatePrices(ProductModel source, ProductData target) {
        List<PriceRowModel> priceRows = source.getPriceRows();
        if (priceRows == null || priceRows.isEmpty()) {
            LOG.warn("Price rows are null or empty in StoreProductPricePopulator");
            return;
        }

        Double msrpPrice = null;
        Double pmatPrice = null;

        for (PriceRowModel priceRow : priceRows) {
            if ("MSRP".equals(priceRow.getType())) {
                msrpPrice = priceRow.getValue();
            }
            if ("PMAT".equals(priceRow.getType())) {
                pmatPrice = priceRow.getValue();
            }
        }

        if (msrpPrice == null || pmatPrice == null) {
            LOG.warn("msrpPrice or PMATPrice price are null");
        }

        if (msrpPrice != null) {
            target.setMsrpPrice(msrpPrice);
        }
        if (pmatPrice != null) {
            target.setPmatPrice(pmatPrice);
        }
    }
}
