package store.facades.populators;

import org.apache.log4j.Logger;

public class StoreProductPricePopulator {

    private static final Logger LOG = Logger.getLogger(StoreProductPricePopulator.class);

    public void populate(ProductModel product, ProductData productData) {
        String productCode = product.getCode();
        Double msrpPrice = product.getMsrpPrice();
        Double pmatPrice = product.getPmatPrice();

        if (msrpPrice == null || pmatPrice == null) {
            LOG.error("MSRP or PMAT Price is missing for product: " + productCode);
            // Optional: Provide fallback or skip this product
            return; // or handle gracefully
        }

        // Existing logic to populate other prices, ensuring msrpPrice and pmatPrice are present
        productData.setMsrpPrice(msrpPrice);
        productData.setPmatPrice(pmatPrice);

        // Any other product data population logic
        Double specialPrice = product.getSpecialPrice();
        if (specialPrice != null) {
            productData.setSpecialPrice(specialPrice);
        }

        // ... other fields, as per original logic
    }
}

class ProductModel {
    private String code;
    private Double msrpPrice;
    private Double pmatPrice;
    private Double specialPrice;

    public String getCode() { return code; }
    public Double getMsrpPrice() { return msrpPrice; }
    public Double getPmatPrice() { return pmatPrice; }
    public Double getSpecialPrice() { return specialPrice; }
}

class ProductData {
    private Double msrpPrice;
    private Double pmatPrice;
    private Double specialPrice;

    public void setMsrpPrice(Double price) { this.msrpPrice = price; }
    public void setPmatPrice(Double price) { this.pmatPrice = price; }
    public void setSpecialPrice(Double price) { this.specialPrice = price; }
}
```
