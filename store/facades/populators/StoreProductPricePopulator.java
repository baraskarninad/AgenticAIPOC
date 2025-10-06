package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import store.services.PriceService;
import store.data.PriceData;
import store.model.SourceProductModel;
import store.data.TargetProductData;
import java.util.Optional;

public class StoreProductPricePopulator implements Populator<SourceProductModel, TargetProductData> {

    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    private PriceService priceService;

    public void setPriceService(PriceService priceService) {
        this.priceService = priceService;
    }

    protected PriceData getDefaultPriceData() {
        // Provide a default PriceData implementation as needed
        PriceData defaultPrice = new PriceData();
        defaultPrice.setValue(0.0);
        defaultPrice.setCurrencyIso("USD");
        return defaultPrice;
    }

    @Override
    public void populate(final SourceProductModel source, final TargetProductData target) throws ConversionException {
        final PriceData msrpPrice = priceService.getMSRP(source);
        final PriceData pmatPrice = priceService.getPMAT(source);

        if (msrpPrice == null || pmatPrice == null) {
            LOG.error("MSRP or PMAT Price is null for product: {}", source.getCode());
            // Optionally set default or throw exception
            target.setMSRP(Optional.ofNullable(msrpPrice).orElseGet(() -> getDefaultPriceData()));
            target.setPMAT(Optional.ofNullable(pmatPrice).orElseGet(() -> getDefaultPriceData()));
            // Or, propagate as a handled business exception
            // throw new PriceNotAvailableException("Missing MSRP/PMAT for product: " + source.getCode());
        } else {
            target.setMSRP(msrpPrice);
            target.setPMAT(pmatPrice);
        }
    }
}
```
