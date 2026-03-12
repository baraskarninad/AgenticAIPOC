package store.facades.populators;

import de.hybris.platform.commerceservices.converter.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.log4j.Logger;
import store.model.SourceProductModel;
import store.data.TargetProductData;
import de.hybris.platform.jalo.order.price.PriceRowModel;

import java.util.List;

public class StoreProductPricePopulator implements Populator<SourceProductModel, TargetProductData> {

    private static final Logger LOG = Logger.getLogger(StoreProductPricePopulator.class);

    private PriceRowService priceRowService;

    @Override
    public void populate(final SourceProductModel source, final TargetProductData target) throws ConversionException {
        List<PriceRowModel> priceRows = priceRowService.getPriceRowsForProduct(source);
        if (priceRows == null || priceRows.isEmpty()) {
            LOG.error("Price rows are null or empty for product {} in catalog {} and currency {}", source.getCode(), source.getCatalogVersion(), source.getCurrency());
            return; // or set a default/empty price on target
        }
        // existing price population logic
        for (PriceRowModel priceRow : priceRows) {
            // Example price population
            if (priceRow.getCurrency().equals(source.getCurrency())) {
                target.setPrice(priceRow.getPrice());
                target.setCurrency(priceRow.getCurrency().getIsocode());
                break;
            }
        }
    }

    public void setPriceRowService(PriceRowService priceRowService) {
        this.priceRowService = priceRowService;
    }
}
```
