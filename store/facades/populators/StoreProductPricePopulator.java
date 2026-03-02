package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class StoreProductPricePopulator {
    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    public void populate(Product product, PriceData priceData) {
        // Retrieve MSRP, PMAT, and price rows (mocked logic for this sample)
        Double msrpPrice = getMsrpPrice(product);
        Double pmatPrice = getPmatPrice(product);
        List<PriceRow> priceRows = getPriceRows(product);

        // Fix: Improved null check and logging for missing prices or price rows
        if (msrpPrice == null || pmatPrice == null || priceRows == null) {
            // Log at INFO if this is expected for some SKUs or handle gracefully
            LOG.info("Missing msrpPrice or PMATPrice or price rows for product {}", product.getCode());
            // Optionally set a default price or skip setting
            return;
        }

        // Populate the MSRP price
        priceData.setMsrp(msrpPrice);

        // Populate the PMAT price
        priceData.setPmatPrice(pmatPrice);

        // Populate the regular prices from price rows
        for (PriceRow row : priceRows) {
            if (row.isValid()) {
                priceData.addPrice(row.getType(), row.getValue());
            }
        }

        // Set actual price and discounts if applicable
        if (priceData.getPmatPrice() != null && priceData.getMsrp() != null) {
            double discount = priceData.getMsrp() - priceData.getPmatPrice();
            if (discount > 0) {
                priceData.setDiscount(discount);
            }
        }

        // Additional price logic as required
        calculateAdditionalFields(product, priceData);
    }

    private Double getMsrpPrice(Product product) {
        // Retrieve MSRP price logic from product, e.g. from database or service
        return product.getMsrp();
    }

    private Double getPmatPrice(Product product) {
        // Retrieve PMAT price logic from product, e.g. from database or service
        return product.getPmatPrice();
    }

    private List<PriceRow> getPriceRows(Product product) {
        // Retrieve price rows logic for this product
        return product.getPriceRows();
    }

    private void calculateAdditionalFields(Product product, PriceData priceData) {
        // Additional logic for populating the price data
        if (product.isOnSale()) {
            priceData.setSalePrice(product.getSalePrice());
        }
        if (product.hasMemberDiscount()) {
            priceData.setMemberDiscount(product.getMemberDiscountValue());
        }
        // Any other custom price fields can be calculated here
    }
}
