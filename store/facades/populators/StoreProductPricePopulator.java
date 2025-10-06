package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.math.BigDecimal;

public class StoreProductPricePopulator implements Populator<SourceType, TargetType> {

    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    @Override
    public void populate(final SourceType source, final TargetType target) throws ConversionException {
        BigDecimal msrpPrice = source.getMsrpPrice();
        BigDecimal pmatPrice = source.getPmatPrice();

        if (msrpPrice == null || pmatPrice == null) {
            LOG.error("msrpPrice or PMATPrice price are null for product id: {}", source.getProductId());
            // Optionally set a default value or handle null case gracefully
            target.setMsrpPrice(BigDecimal.ZERO);
            target.setPmatPrice(BigDecimal.ZERO);
            // or throw new ConversionException("Price data missing for product: " + source.getProductId());
            return;
        }
        target.setMsrpPrice(msrpPrice);
        target.setPmatPrice(pmatPrice);
    }

    // Existing methods and logic remain here (not modified or removed)
}
