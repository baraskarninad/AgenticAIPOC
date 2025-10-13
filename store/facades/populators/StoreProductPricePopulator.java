package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import store.model.ProductModel;
import store.data.ProductData;
import store.service.PriceService;

public class StoreProductPricePopulator
{
    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    private PriceService priceService;

    public void populate(final ProductModel product, final ProductData productData)
    {
        if (product == null || productData == null)
        {
            LOG.error("Product or ProductData is null.");
            return;
        }

        Double msrpPrice = priceService.getMsrpPrice(product);
        Double pmatPrice = priceService.getPmatPrice(product);

        // Fix applied: Properly check for msrpPrice and pmatPrice null
        if (msrpPrice == null || pmatPrice == null) {
            LOG.error("MSRP or PMAT price is null for product: {}", product.getCode());
            // Optionally, you could:
            // - Set a default value
            // - Skip population
            // - Or throw a handled exception
            return;
        } 
        // Continue with normal population logic

        productData.setMsrpPrice(msrpPrice);
        productData.setPmatPrice(pmatPrice);

        // Other existing logic preserved
        productData.setPrice(priceService.getPrice(product));
        productData.setCurrency(priceService.getCurrency(product));

        // Possibly more calculations and population code...
        Double discount = priceService.calculateDiscount(product);
        if (discount != null) {
            productData.setDiscount(discount);
        }

        // Tax-related logic
        if (product.isTaxable()) {
            Double tax = priceService.calculateTax(product, productData.getPrice());
            productData.setTax(tax);
        } else {
            productData.setTax(0.0);
        }

        // Stock and availability logic
        boolean inStock = priceService.isInStock(product);
        productData.setInStock(inStock);
        if (!inStock) {
            productData.setAvailability("Out of Stock");
        } else {
            productData.setAvailability("Available");
        }

        // Additional population logic...
        productData.setPromotion(priceService.getActivePromotion(product));
        productData.setTags(product.getTags());

        // End of population method
    }

    public void setPriceService(final PriceService priceService)
    {
        this.priceService = priceService;
    }
}
