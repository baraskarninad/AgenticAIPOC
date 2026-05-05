package store.facades.populators;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;

public class StoreProductPricePopulator {

    private static final Logger LOG = Logger.getLogger(StoreProductPricePopulator.class);

    public void populatePrices(List<PriceRow> priceRows) {
        BigDecimal msrpPrice = null;
        BigDecimal pmatPrice = null;

        // In StoreProductPricePopulator.java
        if (priceRows == null || priceRows.isEmpty()) {
            LOG.error("Price rows are null or empty, cannot populate msrpPrice or PMATPrice.");
            msrpPrice = BigDecimal.ZERO;
            pmatPrice = BigDecimal.ZERO;
            // Optionally return or throw ApplicationException
            return;
        }

        // Original logic for extracting msrpPrice and pmatPrice from priceRows
        for (PriceRow row : priceRows) {
            if("MSRP".equals(row.getType())) {
                msrpPrice = row.getPrice();
            }
            if("PMAT".equals(row.getType())) {
                pmatPrice = row.getPrice();
            }
        }

        // Defensive null handling for msrp/PMAT
        if (msrpPrice == null) {
            LOG.warn("msrpPrice attribute is null, setting default value.");
            msrpPrice = BigDecimal.ZERO;
        }
        if (pmatPrice == null) {
            LOG.warn("PMATPrice attribute is null, setting default value.");
            pmatPrice = BigDecimal.ZERO;
        }

        // Continue setting these on target object or wherever needed
        setMsrpPrice(msrpPrice);
        setPmatPrice(pmatPrice);
    }

    // Placeholder setters
    private void setMsrpPrice(BigDecimal msrpPrice) {
        // Implementation to set msrpPrice
    }

    private void setPmatPrice(BigDecimal pmatPrice) {
        // Implementation to set pmatPrice
    }

    // Placeholder class for PriceRow
    public static class PriceRow {
        private String type;
        private BigDecimal price;

        public PriceRow(String type, BigDecimal price) {
            this.type = type;
            this.price = price;
        }

        public String getType() {
            return type;
        }

        public BigDecimal getPrice() {
            return price;
        }
    }
}
