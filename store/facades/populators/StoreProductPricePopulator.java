package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import other necessary packages

public class StoreProductPricePopulator
{
    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    // other class variables and dependencies

    public void populate(ProductModel productModel, ProductData productData)
    {
        // Original logic before price fetching

        // Let's suppose this is where MSRP and PMAT prices are fetched/calculated
        Price msrpPrice = null;
        Price pmatPrice = null;

        try {
            msrpPrice = priceService.getMsrpPrice(productModel);
        } catch (Exception e) {
            LOG.error("Exception while fetching MSRP price for product {}: {}", productModel != null ? productModel.getCode() : "unknown", e.getMessage());
        }

        try {
            pmatPrice = priceService.getPmatPrice(productModel);
        } catch (Exception e) {
            LOG.error("Exception while fetching PMAT price for product {}: {}", productModel != null ? productModel.getCode() : "unknown", e.getMessage());
        }

        // FIX: Apply the null check as described in your instructions
        if (msrpPrice == null || pmatPrice == null) {
            LOG.error("MSRP or PMATPrice is null for product: {}", productModel != null ? productModel.getCode() : "unknown");
            // Optionally, set a default value or skip setting the price fields
            return;
        }

        // Existing logic follows (assigning prices, further mapping, etc.)
        productData.setMsrpPrice(msrpPrice.getValue());
        productData.setPmatPrice(pmatPrice.getValue());

        // Any further logic belonging to this class
        if (msrpPrice.getCurrency() != null) {
            productData.setCurrency(msrpPrice.getCurrency().getIsocode());
        }

        // Additional business logic, e.g. perhaps price calculations or discounts, etc.

        // Possibly more logic before the end
    }

    // Other methods and inner classes, if any
}
