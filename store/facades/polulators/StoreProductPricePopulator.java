package store.facades.polulators;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoreProductPricePopulator {

    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    public void populate(ProductModel product, List<PriceRowModel> priceRows, Double msrpPrice, Double pmatPrice) {
        if (msrpPrice == null || pmatPrice == null) {
            String productCode = (product != null && product.getCode() != null) ? product.getCode() : "UNKNOWN";
            LOG.error("msrpPrice or PMATPrice price are null for product: {}", productCode);
            // Optional: set default price or skip processing
            return;
        }
        if (priceRows == null || priceRows.isEmpty()) {
            String productCode = (product != null && product.getCode() != null) ? product.getCode() : "UNKNOWN";
            LOG.error("Price rows are null or empty in StoreProductPricePopulator for product: {}", productCode);
            // Optional: handle gracefully
            return;
        }

        // Further processing logic for setting product price, etc.
        double minPrice = Double.MAX_VALUE;
        for (PriceRowModel priceRow : priceRows) {
            if(priceRow != null && priceRow.getPrice() != null && priceRow.getPrice() < minPrice) {
                minPrice = priceRow.getPrice();
            }
        }

        product.setMsrpPrice(msrpPrice);
        product.setPmatPrice(pmatPrice);
        product.setMinPrice(minPrice);
        LOG.info("Populated prices for product: {}", product.getCode());
    }
}

// Example model classes for completeness

class ProductModel {
    private String code;
    private Double msrpPrice;
    private Double pmatPrice;
    private Double minPrice;

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public void setMsrpPrice(Double price) { this.msrpPrice = price; }

    public void setPmatPrice(Double price) { this.pmatPrice = price; }

    public void setMinPrice(Double price) { this.minPrice = price; }
}

class PriceRowModel {
    private Double price;

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }
}
```
**Fix applied:**  
Added defensive checks so that if `product` or `product.getCode()` is null, product code is logged as "UNKNOWN" to avoid possible `NullPointerException` in the error logging lines.  
All other logic is unchanged per your requirements.