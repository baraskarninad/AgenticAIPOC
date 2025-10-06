package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import store.facades.data.PriceData;
import store.facades.data.SourceType;
import store.facades.data.TargetType;

public class StoreProductPricePopulator implements Populator<SourceType, TargetType> {

    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    @Override
    public void populate(final SourceType source, final TargetType target) throws ConversionException {
        if (source == null || target == null) {
            LOG.error("Source or Target is null in StoreProductPricePopulator");
            return;
        }
        PriceData msrpPrice = source.getMsrpPrice();
        PriceData pmatPrice = source.getPmatPrice();
        if (msrpPrice == null || pmatPrice == null) {
            LOG.error("msrpPrice or PMATPrice price are null in StoreProductPricePopulator for product: {}", source.getCode());
            // Optionally set default/fallback values or abort cleanly
            return;
        }
        target.setMsrpPrice(msrpPrice);
        target.setPmatPrice(pmatPrice);
    }

}
