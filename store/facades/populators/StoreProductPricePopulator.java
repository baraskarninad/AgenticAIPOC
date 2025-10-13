package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import store.core.model.SourceProductModel;
import store.facades.data.TargetData;
import java.math.BigDecimal;
import java.util.Objects;

public class StoreProductPricePopulator implements Populator<SourceProductModel, TargetData> {

    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    @Override
    public void populate(final SourceProductModel source, final TargetData target) {
        if (source == null) {
            throw new IllegalArgumentException("SourceProductModel cannot be null");
        }
        if (target == null) {
            throw new IllegalArgumentException("TargetData cannot be null");
        }

        // Validate msrpPrice and PMATPrice - fix applied here
        if (source.getMsrpPrice() == null || source.getPmatPrice() == null) {
            LOG.error("msrpPrice or PMATPrice price are null for product {}", source.getCode());
            // Optionally: throw new IllegalStateException("Product pricing fields are missing");
            // Optionally: set default/fallback value or skip population
            return;
        }

        target.setProductCode(source.getCode());
        target.setProductName(source.getName());
        target.setMsrpPrice(source.getMsrpPrice() != null ? source.getMsrpPrice() : BigDecimal.ZERO);
        target.setPmatPrice(source.getPmatPrice() != null ? source.getPmatPrice() : BigDecimal.ZERO);
        target.setCurrency(source.getCurrency());

        if (!CollectionUtils.isEmpty(source.getDiscounts())) {
            target.setDiscounts(BeanUtils.instantiateClass(source.getDiscounts().getClass()));
            target.getDiscounts().addAll(source.getDiscounts());
        }

        if (Objects.nonNull(source.getProductType())) {
            target.setProductType(source.getProductType().toString());
        }

        // Copy additional fields as required
        target.setActive(source.isActive());
        target.setAvailableQuantity(source.getAvailableQuantity());

        if (source.getAttributes() != null) {
            target.setAttributes(source.getAttributes());
        }

        // Any other population logic remains intact
    }
}
