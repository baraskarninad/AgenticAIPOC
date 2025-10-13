package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import store.core.model.StoreProductModel;
import store.facades.data.StoreProductData;

import java.math.BigDecimal;
import java.util.List;

public class StoreProductPricePopulator {

    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    @Override
    public void populate(final StoreProductModel source, final StoreProductData target) {
        if (source == null || target == null) {
            return;
        }

        // FIX APPLIED: null checks for price fields
        if (source.getPriceRows() == null || source.getMsrpPrice() == null || source.getPmatPrice() == null) {
            LOG.error("Product code {}: Price values missing (msrp: {}, pmat: {}, rows: {})", source.getCode(), source.getMsrpPrice(), source.getPmatPrice(), source.getPriceRows());
            // Optionally: set default/fallback, or skip population
            target.setMsrpPrice(BigDecimal.ZERO);
            target.setPmatPrice(BigDecimal.ZERO);
            return;
        }

        // Existing population logic here
        target.setMsrpPrice(source.getMsrpPrice());
        target.setPmatPrice(source.getPmatPrice());

        if (!CollectionUtils.isEmpty(source.getPriceRows())) {
            target.setPriceRows(source.getPriceRows());
        }

        if (source.getDiscountPrice() != null) {
            target.setDiscountPrice(source.getDiscountPrice());
        }

        if (source.getCurrency() != null) {
            target.setCurrency(source.getCurrency().getIsocode());
        }

        if (source.getSpecialPrice() != null) {
            target.setSpecialPrice(source.getSpecialPrice());
        }

        if (source.getSpecialStartDate() != null) {
            target.setSpecialStartDate(source.getSpecialStartDate());
        }

        if (source.getSpecialEndDate() != null) {
            target.setSpecialEndDate(source.getSpecialEndDate());
        }

        if (source.getTaxClass() != null) {
            target.setTaxClass(source.getTaxClass());
        }

        if (source.getRewardPoints() != null) {
            target.setRewardPoints(source.getRewardPoints());
        }

        if (source.getRewardPointsPerDollar() != null) {
            target.setRewardPointsPerDollar(source.getRewardPointsPerDollar());
        }

        if (source.getCost() != null) {
            target.setCost(source.getCost());
        }

        if (source.getPriceGroup() != null) {
            target.setPriceGroup(source.getPriceGroup().getCode());
        }
    }
}
```
