package store.facades.populators;

import org.apache.log4j.Logger;
import java.util.List;

public class StoreProductPricePopulator {
    private static final Logger LOG = Logger.getLogger(StoreProductPricePopulator.class);

    public void populate(Product product, PriceData msrpPrice, PriceData pmatPrice, List<PriceRow> priceRows) {
        if (product == null) {
            LOG.error("Product is null. Unable to populate prices.");
            return;
        }
        if (msrpPrice == null) {
            LOG.error("msrpPrice is null. Unable to populate prices for product " + product.getCode());
            return;
        }
        if (pmatPrice == null) {
            LOG.error("PMATPrice is null. Unable to populate prices for product " + product.getCode());
            return;
        }
        if (priceRows == null) {
            LOG.error("priceRows is null. Unable to populate prices for product " + product.getCode());
            return;
        }

        // Existing population logic follows here
        product.setMsrpPrice(msrpPrice);
        product.setPmatPrice(pmatPrice);
        product.setPriceRows(priceRows);

        for (PriceRow row : priceRows) {
            if (row.getPrice() == null) {
                LOG.warn("PriceRow with null price detected for product " + product.getCode());
                continue;
            }
            // Additional business logic for price row population
            if (row.getType().equals("discount")) {
                product.applyDiscount(row.getPrice());
            }
            if (row.getType().equals("tax")) {
                product.applyTax(row.getPrice());
            }
        }

        if (product.getMsrpPrice() != null && product.getPmatPrice() != null) {
            product.setBestPrice(product.getMsrpPrice().compareTo(product.getPmatPrice()) < 0 ? product.getMsrpPrice() : product.getPmatPrice());
        } else if (product.getMsrpPrice() != null) {
            product.setBestPrice(product.getMsrpPrice());
        } else if (product.getPmatPrice() != null) {
            product.setBestPrice(product.getPmatPrice());
        }

        LOG.info("Populated prices for product " + product.getCode());
    }
}
