package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class StoreProductPricePopulator {

    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    public void populate(Product source, ProductData target) {
        if (source == null || target == null) {
            LOG.error("Source or target is null in StoreProductPricePopulator.");
            return;
        }

        List<PriceRow> priceRows = source.getPriceRows();

        // Fix applied: check and log if priceRows are null or empty
        if (priceRows == null || priceRows.isEmpty()) {
            LOG.error("Price rows are null or empty while populating product prices. Product: {}", source.getCode());
            // Optionally provide default/fallback pricing here.
            return;
        }

        // Fix applied: check and log if MSRP or PMAT prices are null
        if (source.getMsrpPrice() == null || source.getPmatPrice() == null) {
            LOG.error("MSRP or PMAT prices are null for product: {}", source.getCode());
            // Optionally handle the missing value (show placeholder, fallback logic, etc.)
        }

        // --- existing logic below ---
        for (PriceRow priceRow : priceRows) {
            if (priceRow.getType().equals("REGULAR")) {
                target.setRegularPrice(priceRow.getPrice());
            } else if (priceRow.getType().equals("SALE")) {
                target.setSalePrice(priceRow.getPrice());
            }
        }

        if (source.getMsrpPrice() != null) {
            target.setMsrpPrice(source.getMsrpPrice());
        }
        if (source.getPmatPrice() != null) {
            target.setPmatPrice(source.getPmatPrice());
        }

        // Additional logic as necessary...
    }
}

// Supporting classes for context (these would normally be in their own files)
class Product {
    private String code;
    private List<PriceRow> priceRows;
    private Double msrpPrice;
    private Double pmatPrice;

    public String getCode() { return code; }
    public List<PriceRow> getPriceRows() { return priceRows; }
    public Double getMsrpPrice() { return msrpPrice; }
    public Double getPmatPrice() { return pmatPrice; }
}

class ProductData {
    public void setRegularPrice(Double price) { /* ... */ }
    public void setSalePrice(Double price) { /* ... */ }
    public void setMsrpPrice(Double price) { /* ... */ }
    public void setPmatPrice(Double price) { /* ... */ }
}

class PriceRow {
    private String type;
    private Double price;

    public String getType() { return type; }
    public Double getPrice() { return price; }
}
```
