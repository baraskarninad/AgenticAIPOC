package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class StoreProductPricePopulator extends SomeBasePopulator {

    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    @Override
    public void populate(final SourceProduct source, final TargetProduct target) {
        if (source == null || target == null) {
            LOG.error("Source or Target is null in StoreProductPricePopulator");
            return;
        }
        List<PriceRowModel> priceRows = null;
        try {
            priceRows = source.getPriceRows();
        } catch (Exception e) {
            LOG.error("Exception while fetching price rows for product: {}", source != null ? source.getCode() : "null", e);
            target.setMsrpPrice(null);
            target.setPmatPrice(null);
            return;
        }
        if (priceRows == null || priceRows.isEmpty()) {
            LOG.error("Price rows are null or empty for product: {}", source.getCode());
            target.setMsrpPrice(null);
            target.setPmatPrice(null);
            return;
        }
        // Continue normal price population logic here
    }
}
