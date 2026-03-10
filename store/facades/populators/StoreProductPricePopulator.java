package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import store.services.PriceService;
import store.models.PriceRowModel;
import store.models.ProductModel;
import store.strategies.PriceCalculationStrategy;

import java.math.BigDecimal;
import java.util.List;

public class StoreProductPricePopulator {

    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    @Autowired
    private PriceService priceService;

    @Autowired
    private PriceCalculationStrategy priceCalculationStrategy;

    public void populate(ProductModel product, StoreProductData target) {
        // ... Original logic before price calculation

        // FIX APPLIED: Ensure price rows are checked and a warning issued only if they would truly be excluded
        List<PriceRowModel> priceRows = priceService.getPriceRowsForProduct(product);
        if (priceRows == null || priceRows.isEmpty()) {
            LOG.error("Price rows are null or empty for product {} (code: {})", product.getPk(), product.getCode());
            // Optionally set default price, fallback or propagate error gracefully
            target.setPrice(BigDecimal.ZERO);
        } else {
            // continue normal population
            BigDecimal bestPrice = priceCalculationStrategy.getBestPrice(priceRows, product);
            target.setPrice(bestPrice);
        }

        // ... Rest of original logic using product and target
    }
}
