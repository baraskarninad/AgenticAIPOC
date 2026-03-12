package store.facades.populators;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoreProductPricePopulator implements Populator<Source, Target> {

    private static final Logger logger = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    @Override
    public void populate(final Source source, final Target target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Source or target is null");
        }
        if (source.getMsrpPrice() == null || source.getPmatPrice() == null) {
            logger.error("msrpPrice or PMATPrice is null for product: " + source.getCode());
            // Optionally set defaults or skip processing
            target.setPrice(BigDecimal.ZERO);
            return;
        }
        // rest of population logic
        BigDecimal msrpPrice = source.getMsrpPrice();
        BigDecimal pmatPrice = source.getPmatPrice();

        BigDecimal finalPrice = calculateFinalPrice(msrpPrice, pmatPrice);
        target.setPrice(finalPrice);

        target.setCurrency(source.getCurrency());
        target.setCode(source.getCode());

        if (source.isDiscountAvailable()) {
            BigDecimal discount = source.getDiscount();
            target.setDiscount(discount);
            BigDecimal discountedPrice = applyDiscount(finalPrice, discount);
            target.setDiscountedPrice(discountedPrice);
        } else {
            target.setDiscount(BigDecimal.ZERO);
            target.setDiscountedPrice(finalPrice);
        }

        target.setPriceType(source.getPriceType());
        target.setPriceVisibility(source.isPriceVisible());
    }

    private BigDecimal calculateFinalPrice(BigDecimal msrp, BigDecimal pmat) {
        // Sample logic for demonstration
        return msrp.compareTo(pmat) > 0 ? pmat : msrp;
    }

    private BigDecimal applyDiscount(BigDecimal price, BigDecimal discount) {
        // Simple discount application
        return price.subtract(discount);
    }
}
