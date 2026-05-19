package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class StoreProductPricePopulator {

    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    // Existing variables
    private Double msrpPrice;
    private Double pmatPrice;

    public void populate(Product product, List<PriceRow> priceRows) {
        // Example code fix for StoreProductPricePopulator.java

        if (priceRows == null || priceRows.isEmpty()) {
            LOG.error("Price rows are null or empty for product: {}", product.getCode());
            msrpPrice = getDefaultMsrpPrice();
            pmatPrice = getDefaultPmatPrice();
            // Optionally: skip product or set error flag
            return;
        }
        if (msrpPrice == null) {
            LOG.warn("msrpPrice is null for product: {}", product.getCode());
            msrpPrice = getDefaultMsrpPrice();
        }
        if (pmatPrice == null) {
            LOG.warn("pmatPrice is null for product: {}", product.getCode());
            pmatPrice = getDefaultPmatPrice();
        }

        // Example of original logic that must not be removed or abstracted
        for (PriceRow row : priceRows) {
            if ("MSRP".equals(row.getPriceType())) {
                msrpPrice = row.getPrice();
            }
            if ("PMAT".equals(row.getPriceType())) {
                pmatPrice = row.getPrice();
            }
        }

        // Set prices on product or DTO
        product.setMsrpPrice(msrpPrice);
        product.setPmatPrice(pmatPrice);
    }

    private Double getDefaultMsrpPrice() {
        // Example implementation
        return 0.0;
    }

    private Double getDefaultPmatPrice() {
        // Example implementation
        return 0.0;
    }

    // Dummy inner classes for context (should exist elsewhere in your codebase)
    public static class Product {
        private String code;
        private Double msrpPrice;
        private Double pmatPrice;

        public String getCode() { return code; }
        public void setMsrpPrice(Double price) { this.msrpPrice = price; }
        public void setPmatPrice(Double price) { this.pmatPrice = price; }
    }

    public static class PriceRow {
        private String priceType;
        private Double price;

        public String getPriceType() { return priceType; }
        public Double getPrice() { return price; }
    }
}
```
