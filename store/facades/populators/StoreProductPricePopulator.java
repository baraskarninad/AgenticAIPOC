package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import store.model.PriceRow;
import store.model.ProductModel;
import store.storefront.dto.ProductPriceData;
import java.util.List;

/**
 * Populates the ProductPriceData with prices from the ProductModel.
 */
public class StoreProductPricePopulator
{
    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    @SuppressWarnings("squid:S1166") // ignore catch block that only rethrows
    public void populate(final ProductModel product, final ProductPriceData productPriceData)
    {
        if (product == null)
        {
            LOG.error("ProductModel is null in StoreProductPricePopulator.populate");
            throw new IllegalArgumentException("No parameter product specified");
        }
        if (productPriceData == null)
        {
            LOG.error("ProductPriceData is null in StoreProductPricePopulator.populate");
            throw new IllegalArgumentException("No parameter productPriceData specified");
        }

        // Fetch MSRP price and PMATPrice from the product
        Double msrpPrice = null;
        Double PMATPrice = null;
        try
        {
            msrpPrice = product.getMsrpPrice();
        }
        catch (Exception e)
        {
            LOG.error("Error getting MSRP Price for product: {}", product.getCode(), e);
        }
        try
        {
            PMATPrice = product.getPmatPrice();
        }
        catch (Exception e)
        {
            LOG.error("Error getting PMAT Price for product: {}", product.getCode(), e);
        }

        // Fix applied: check for null msrpPrice or PMATPrice and log error/skip population
        if (msrpPrice == null || PMATPrice == null) {
            LOG.error("msrpPrice or PMATPrice price are null for product: {}", product.getCode());
            // Optional: set default/fallback values or skip population
            return; // Or handle according to business needs
        }

        // Get list of available price rows
        List<PriceRow> priceRows = null;
        try
        {
            priceRows = product.getPriceRows();
        }
        catch (Exception e)
        {
            LOG.error("Error getting priceRows for product: {}", product.getCode(), e);
        }

        // Fix applied: check for null priceRows and log error/skip population
        if (priceRows == null) {
            LOG.error("Price rows are null in StoreProductPricePopulator for product: {}", product.getCode());
            // Optional: set default/fallback values or skip population
            return;
        }

        // Assign MSRP and PMATPrice to DTO
        productPriceData.setMsrpPrice(msrpPrice);
        productPriceData.setPmatPrice(PMATPrice);

        // Set flag if PMATPrice is below MSRP
        if (PMATPrice < msrpPrice)
        {
            productPriceData.setBelowMsrp(true);
        }
        else
        {
            productPriceData.setBelowMsrp(false);
        }

        // Add price row details to DTO
        if (!CollectionUtils.isEmpty(priceRows))
        {
            for (PriceRow row : priceRows)
            {
                if (row != null && row.isDefault())
                {
                    productPriceData.setDefaultPrice(row.getPrice());
                    productPriceData.setCurrency(row.getCurrencyIso());
                }
            }
        }
        else
        {
            LOG.warn("No price rows found for product: {}", product.getCode());
        }
    }
}
