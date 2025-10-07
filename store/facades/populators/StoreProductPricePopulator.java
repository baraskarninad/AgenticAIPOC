package store.facades.populators;

import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

public class StoreProductPricePopulator implements Populator<SourceType, TargetType> {
    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    @Override
    public void populate(final SourceType source, final TargetType target) throws ConversionException {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Source or target cannot be null.");
        }
        // Fetch price rows safely
        final List<PriceRow> priceRows = source.getPriceRows();
        if (priceRows == null || priceRows.isEmpty()) {
            LOG.warn("Price rows are null or empty in StoreProductPricePopulator for product {}", source.getCode());
            // Set default/empty price values or skip assignment
            target.setMsrpPrice(BigDecimal.ZERO);
            target.setPmatPrice(BigDecimal.ZERO);
            return;
        }
        BigDecimal msrpPrice = null;
        BigDecimal pmatPrice = null;
        // Find specific prices
        for (PriceRow row : priceRows) {
            if (row.isMsrp()) {
                msrpPrice = row.getPrice();
            }
            if (row.isPmat()) {
                pmatPrice = row.getPrice();
            }
        }
        if (msrpPrice == null) {
            LOG.warn("MSRP price is null for product {}", source.getCode());
            msrpPrice = BigDecimal.ZERO; // or another default/fallback
        }
        if (pmatPrice == null) {
            LOG.warn("PMAT price is null for product {}", source.getCode());
            pmatPrice = BigDecimal.ZERO; // or another default/fallback
        }
        target.setMsrpPrice(msrpPrice);
        target.setPmatPrice(pmatPrice);
    }
}
```
