package store.facades.populators;

import java.math.BigDecimal;
import org.apache.log4j.Logger;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import store.models.Source;
import store.models.Target;

public class StoreProductPricePopulator implements Populator<Source, Target> {

    private static final Logger LOG = Logger.getLogger(StoreProductPricePopulator.class);

    @Override
    public void populate(final Source source, final Target target) throws ConversionException {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Source or Target is null");
        }
        // Ensure price rows exist
        if (source.getPriceRows() == null || source.getPriceRows().isEmpty()) {
            LOG.error("Price rows are null or empty in StoreProductPricePopulator");
            target.setMsrpPrice(BigDecimal.ZERO); // or handle as per bus. logic
            target.setPmatPrice(BigDecimal.ZERO); // or handle as per bus. logic
            return;
        }
        // Populate msrpPrice and PMATPrice
        if (source.getMsrpPrice() == null) {
            LOG.error("msrpPrice is null in StoreProductPricePopulator");
            target.setMsrpPrice(BigDecimal.ZERO);
        } else {
            target.setMsrpPrice(source.getMsrpPrice());
        }
        if (source.getPmatPrice() == null) {
            LOG.error("PMATPrice is null in StoreProductPricePopulator");
            target.setPmatPrice(BigDecimal.ZERO);
        } else {
            target.setPmatPrice(source.getPmatPrice());
        }
    }
}
