package store.facades.populators;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoreProductPricePopulator {

    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    public void populate(final SourceModel source, final TargetData target) {
        if (source == null || target == null) {
            LOG.error("Source or target is null in populate");
            return;
        }
        if (source.getPriceRows() == null || source.getPriceRows().isEmpty()) {
            LOG.error("Price rows are null or empty for product: {}", source.getCode());
            // Optionally: set default price, throw exception, or notify support
            target.setMsrpPrice(BigDecimal.ZERO);
            target.setPmatPrice(BigDecimal.ZERO);
            return;
        }
        BigDecimal msrpPrice = source.getMsrpPrice();
        BigDecimal pmatPrice = source.getPmatPrice();
        if (msrpPrice == null || pmatPrice == null) {
            LOG.error("msrpPrice or pmatPrice is null for product: {}", source.getCode());
            // Set fallback or report as desired
            target.setMsrpPrice(BigDecimal.ZERO);
            target.setPmatPrice(BigDecimal.ZERO);
            return;
        }
        target.setMsrpPrice(msrpPrice);
        target.setPmatPrice(pmatPrice);
    }

    // other methods, fields, etc. remain unchanged
}
