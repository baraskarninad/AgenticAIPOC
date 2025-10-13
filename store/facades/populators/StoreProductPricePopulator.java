package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigDecimal;
import java.util.List;

public class StoreProductPricePopulator {

    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    public void populate(Product product, List<PriceRow> priceRows, BigDecimal msrpPrice, BigDecimal pmatPrice) {

        if (priceRows == null || priceRows.isEmpty() || msrpPrice == null || pmatPrice == null) {
            LOG.error("Price population failed for product [{}]. msrpPrice: {}, pmatPrice: {}, priceRows: {}",
                    product != null ? product.getCode() : "unknown", msrpPrice, pmatPrice, priceRows);
            // Optionally: provide fallback value or further escalation
            // e.g. msrpPrice = BigDecimal.ZERO;
            // pmatPrice = BigDecimal.ZERO;
            return; // or handle error appropriately
        }

        // Rest of the population logic
        if(product != null) {
            product.setMsrpPrice(msrpPrice);
            product.setPmatPrice(pmatPrice);
        }
        
        if(priceRows != null) {
            for(PriceRow row : priceRows) {
                // Example of processing each PriceRow
                if(row != null && row.getPrice() != null) {
                    // Assume addPrice is a method that adds a price to the product
                    if(product != null) {
                        product.addPrice(row.getPrice());
                    }
                }
            }
        }

        // Additional logic if any
        LOG.info("Product [{}] prices populated successfully.", product != null ? product.getCode() : "unknown");
    }

    // Mock classes for demonstration
    public static class Product {
        private String code;
        private BigDecimal msrpPrice;
        private BigDecimal pmatPrice;

        public String getCode() { return code; }
        public void setCode(String code) { this.code = code; }

        public void setMsrpPrice(BigDecimal msrpPrice) { this.msrpPrice = msrpPrice; }
        public void setPmatPrice(BigDecimal pmatPrice) { this.pmatPrice = pmatPrice; }

        public void addPrice(BigDecimal price) {
            // Logic to add price
        }
    }

    public static class PriceRow {
        private BigDecimal price;

        public BigDecimal getPrice() { return price; }
        public void setPrice(BigDecimal price) { this.price = price; }
    }
}
