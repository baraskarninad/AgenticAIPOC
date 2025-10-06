package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import store.facades.data.StoreProductData;
import store.model.StoreProductModel;

import java.math.BigDecimal;
import java.util.List;

public class StoreProductPricePopulator implements org.springframework.core.convert.converter.Converter<StoreProductModel, StoreProductData> {

    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    @Override
    public StoreProductData convert(StoreProductModel source) {
        StoreProductData target = new StoreProductData();
        populate(source, target);
        return target;
    }

    public void populate(StoreProductModel source, StoreProductData target) {
        if (source == null || target == null) {
            LOG.error("Source or target is null in StoreProductPricePopulator");
            return;
        }

        final List<StoreProductModel.PriceRow> priceRows = source.getPriceRows();
        final StoreProductModel product = source; // as per usage

        // Add in StoreProductPricePopulator.java

        if (priceRows == null || priceRows.isEmpty()) {
            LOG.error("Price rows are null or empty while populating prices for product: {}", product.getCode());
            target.setMsrpPrice(BigDecimal.ZERO); // or a suitable default/fallback
            target.setPmatPrice(BigDecimal.ZERO); // or a suitable default/fallback
            // Optionally: set a flag or add error info
            return;
        }

        if (source.getMsrpPrice() == null) {
            LOG.warn("msrpPrice is null for product: {}", product.getCode());
            target.setMsrpPrice(BigDecimal.ZERO); // or business default
        }
        if (source.getPmatPrice() == null) {
            LOG.warn("pmatPrice is null for product: {}", product.getCode());
            target.setPmatPrice(BigDecimal.ZERO); // or business default
        }

        // existing logic
        // Populate MSRP Price
        if (source.getMsrpPrice() != null) {
            target.setMsrpPrice(source.getMsrpPrice());
        }

        // Populate PMAT Price
        if (source.getPmatPrice() != null) {
            target.setPmatPrice(source.getPmatPrice());
        }

        // Populate other fields
        target.setCode(source.getCode());
        target.setName(source.getName());
        if (!CollectionUtils.isEmpty(priceRows)) {
            for (StoreProductModel.PriceRow priceRow : priceRows) {
                if (priceRow != null && priceRow.isActive()) {
                    target.getActivePrices().add(priceRow.toData());
                }
            }
        }

        // handle additional logic if any
        // For example: currency, formatted price, special price logic, etc.
        if (source.isSpecialPriceActive()) {
            target.setSpecialPriceActive(true);
            target.setSpecialPrice(source.getSpecialPrice());
        } else {
            target.setSpecialPriceActive(false);
        }
    }
}
