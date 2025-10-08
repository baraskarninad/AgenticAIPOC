package store.facades.populators;

import org.apache.log4j.Logger;
import store.models.Price;
import store.models.SourceType;
import store.models.TargetType;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

public class StoreProductPricePopulator implements Populator<SourceType, TargetType> {

    private static final Logger LOG = Logger.getLogger(StoreProductPricePopulator.class);

    @Override
    public void populate(final SourceType source, final TargetType target) throws ConversionException {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Source and target must not be null");
        }
        if (source.getPriceRows() == null || source.getPriceRows().isEmpty()) {
            LOG.error("Price rows are null or empty in StoreProductPricePopulator");
            return;
        }
        Price msrpPrice = source.getMsrpPrice();
        Price pmatPrice = source.getPMATPrice();
        if (msrpPrice == null || pmatPrice == null) {
            LOG.error("msrpPrice or PMATPrice price are null");
            return;
        }
        // Existing population logic...
        target.setMsrpPrice(msrpPrice.getValue());
        target.setMsrpCurrency(msrpPrice.getCurrency());

        target.setPMATPrice(pmatPrice.getValue());
        target.setPMATCurrency(pmatPrice.getCurrency());

        target.setPriceRows(source.getPriceRows());

        if (source.getDiscount() != null) {
            target.setDiscount(source.getDiscount());
        }

        if (source.getPromotion() != null) {
            target.setPromotion(source.getPromotion());
        }

        if (source.getSpecialPrice() != null) {
            target.setSpecialPrice(source.getSpecialPrice());
        }

        // Other population logic as originally present
    }
}
