import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigDecimal;
import java.util.List;

public class StoreProductPricePopulator {
    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    public void populate(ProductSource source, ProductData target) {
        List<PriceRowData> priceRows = source.getPriceRows();

        if (priceRows == null || priceRows.isEmpty()) {
            LOG.warn("Price rows are null or empty in StoreProductPricePopulator");
            return;
        }

        BigDecimal msrpPrice = null;
        BigDecimal pmatPrice = null;

        for (PriceRowData priceRow : priceRows) {
            if ("MSRP".equals(priceRow.getType())) {
                msrpPrice = priceRow.getValue();
            } else if ("PMAT".equals(priceRow.getType())) {
                pmatPrice = priceRow.getValue();
            }
        }

        if (msrpPrice == null || pmatPrice == null) {
            LOG.warn("msrpPrice or PMATPrice price are null");
        }

        target.setMsrpPrice(msrpPrice);
        target.setPMATPrice(pmatPrice);
    }
}