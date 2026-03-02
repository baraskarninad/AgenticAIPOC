package store.facades.populators;

import org.apache.log4j.Logger;

public class StoreProductPricePopulator {

    private static final Logger LOG = Logger.getLogger(StoreProductPricePopulator.class);

    public void populate(ProductModel productModel, ProductData productData) {
        String productCode = productModel.getCode();
        PriceRow priceRow = getPriceRowForProduct(productModel);

        // Apply the fix: also check if priceRow.getMsrpPrice() is not a valid number (e.g. negative)
        if (priceRow == null || priceRow.getMsrpPrice() == null || priceRow.getPMATPrice() == null
                || priceRow.getMsrpPrice().doubleValue() < 0 || priceRow.getPMATPrice().doubleValue() < 0) {
            LOG.error("Null price row or msrpPrice/PMATPrice for product: " + productCode);
            // Set default or skip population
            return;
        }

        productData.setMsrpPrice(priceRow.getMsrpPrice());
        productData.setPmatPrice(priceRow.getPMATPrice());

        // Existing logic continues
        productData.setCurrency(priceRow.getCurrency());
        productData.setPriceEffectiveDate(priceRow.getPriceEffectiveDate());

        // Additional logic
        if (priceRow.getDiscount() != null) {
            productData.setDiscount(priceRow.getDiscount());
        }
        if (priceRow.getSalePrice() != null && priceRow.getSalePrice().doubleValue() >= 0) {
            productData.setSalePrice(priceRow.getSalePrice());
        }

        // Other population logic...
    }

    private PriceRow getPriceRowForProduct(ProductModel productModel) {
        // Method to fetch PriceRow object for the given product
        // ... logic unchanged ...
        return productModel.getPriceRow();
    }
}
