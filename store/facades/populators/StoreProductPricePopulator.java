package store.facades.populators;

import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.converter.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import store.model.SourceProductModel;
import store.facades.data.TargetProductData;
import store.model.PriceRowModel;
import store.services.PriceService;

import java.util.List;

public class StoreProductPricePopulator implements Populator<SourceProductModel, TargetProductData>
{
    private static final Logger LOG = Logger.getLogger(StoreProductPricePopulator.class);

    private PriceService priceService;

    @Override
    public void populate(final SourceProductModel source, final TargetProductData target) throws ConversionException
    {
        final List<PriceRowModel> priceRows = priceService.getPriceRowsForProduct(source);
        if (priceRows == null || priceRows.isEmpty()) {
            LOG.error("Price rows are null or empty for product: {}", source != null ? source.getCode() : "null");
            // You may want to set a default price, throw a controlled exception, or handle gracefully here
            return;
        }
        // Example logic: calculate price and assign
        PriceRowModel bestPrice = null;
        for (PriceRowModel priceRow : priceRows) {
            if (bestPrice == null || priceRow.getPrice() < bestPrice.getPrice()) {
                bestPrice = priceRow;
            }
        }
        if (bestPrice != null) {
            target.setPrice(bestPrice.getPrice());
            target.setCurrency(bestPrice.getCurrencyIso());
        }
    }

    @Required
    public void setPriceService(final PriceService priceService)
    {
        this.priceService = priceService;
    }

    public PriceService getPriceService()
    {
        return priceService;
    }
}
