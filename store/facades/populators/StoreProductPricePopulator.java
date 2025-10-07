package store.facades.populators;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import store.models.PriceModel;
import store.models.SourceProductModel;
import store.data.TargetProductData;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

public class StoreProductPricePopulator implements Populator<SourceProductModel, TargetProductData> {

    private static final Logger LOG = Logger.getLogger(StoreProductPricePopulator.class);

    @Override
    public void populate(final SourceProductModel source, final TargetProductData target) throws ConversionException {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Source and target must not be null");
        }
        PriceModel msrpPrice = source.getMsrpPrice();
        PriceModel pmatPrice = source.getPmatPrice();

        if (msrpPrice == null || pmatPrice == null) {
            LOG.error(String.format("msrpPrice or PMATPrice price are null for product code %s", source.getCode()));
            target.setMsrpPrice(BigDecimal.ZERO); // or an appropriate default
            target.setPmatPrice(BigDecimal.ZERO); // or an appropriate default
            // Optionally: set an error flag or take further fallback action
            return;
        }
        target.setMsrpPrice(msrpPrice.getValue());
        target.setPmatPrice(pmatPrice.getValue());

        // --- original logic continues here ---
        // If there is additional logic after setting msrpPrice and pmatPrice,
        // it will stay intact as per requirements.

        // For example:
        // BigDecimal savings = msrpPrice.getValue().subtract(pmatPrice.getValue());
        // target.setSavings(savings);
        // ... any more logic ...
    }
}
