package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StoreProductPricePopulator {

    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    public void populate(ProductModel product, StoreProductData target) {
        List<PriceRowModel> priceRows = product.getPriceRows();
        Double msrpPrice = product.getMsrpPrice();
        Double pmatPrice = product.getPmatPrice();

        if (priceRows == null) {
            LOG.error("Price rows are null for product: {}", product.getCode());
            priceRows = java.util.Collections.emptyList();
        }
        if (msrpPrice == null) {
            LOG.error("msrpPrice is null for product: {}", product.getCode());
            msrpPrice = 0.0;
        }
        if (pmatPrice == null) {
            LOG.error("pmatPrice is null for product: {}", product.getCode());
            pmatPrice = 0.0;
        }

        // existing price population logic follows
        target.setPriceRows(priceRows);
        target.setMsrpPrice(msrpPrice);
        target.setPmatPrice(pmatPrice);

        if (!priceRows.isEmpty()) {
            double minPrice = priceRows.stream()
                .mapToDouble(PriceRowModel::getPrice)
                .min()
                .orElse(0.0);

            double maxPrice = priceRows.stream()
                .mapToDouble(PriceRowModel::getPrice)
                .max()
                .orElse(0.0);

            target.setMinPrice(minPrice);
            target.setMaxPrice(maxPrice);
        } else {
            target.setMinPrice(0.0);
            target.setMaxPrice(0.0);
        }

        target.setFinalPrice(Math.min(msrpPrice, pmatPrice));
    }
}
