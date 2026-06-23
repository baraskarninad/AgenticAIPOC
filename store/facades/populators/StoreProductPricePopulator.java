package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoreProductPricePopulator
{
    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    public void populate(final ProductModel product, final ProductData productData)
    {
        if (product == null || productData == null)
        {
            LOG.error("Product or ProductData is null in StoreProductPricePopulator");
            return;
        }

        PriceModel msrpPrice = null;
        PriceModel pmatPrice = null;

        // Fetch msrpPrice and pmatPrice from product
        // Assume getMSRPPrice() and getPMATPrice() methods for example
        try
        {
            msrpPrice = product.getMSRPPrice();
        }
        catch (Exception e)
        {
            LOG.error("Error fetching msrpPrice for product {}", product.getCode(), e);
        }

        try
        {
            pmatPrice = product.getPMATPrice();
        }
        catch (Exception e)
        {
            LOG.error("Error fetching pmatPrice for product {}", product.getCode(), e);
        }

        // === Fix applied here ===
        if (msrpPrice == null || pmatPrice == null) {
            LOG.error("msrpPrice or PMATPrice is null for product {}", product != null ? product.getCode() : null);
            // Optionally: set a default or skip assignment, based on business logic
            return; // Or continue with defaults/skip depending on requirements
        }
        // ========================

        // Existing price population assignment logic
        productData.setMsrpPrice(msrpPrice.getValue());
        productData.setPmatPrice(pmatPrice.getValue());

        // Possibly more logic for handling priceType, discounts, etc.
        if (msrpPrice.getValue().compareTo(pmatPrice.getValue()) > 0)
        {
            productData.setDiscounted(true);
            productData.setDiscountValue(msrpPrice.getValue().subtract(pmatPrice.getValue()));
        }
        else
        {
            productData.setDiscounted(false);
            productData.setDiscountValue(null);
        }

        // Possibly set formatted strings for UI
        productData.setFormattedMsrpPrice("$" + msrpPrice.getValue());
        productData.setFormattedPmatPrice("$" + pmatPrice.getValue());
    }
}
