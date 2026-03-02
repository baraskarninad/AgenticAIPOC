package store.facades.populators;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import store.facades.data.StoreProductPriceData;

public class StoreProductPricePopulator implements Populator<ProductModel, StoreProductPriceData> {

    private static final Logger LOG = Logger.getLogger(StoreProductPricePopulator.class);

    @Override
    public void populate(final ProductModel productModel, final StoreProductPriceData target) {
        Assert.notNull(productModel, "Parameter 'productModel' cannot be null.");
        Assert.notNull(target, "Parameter 'target' cannot be null.");

        Double msrpPrice = null;
        Double pmatPrice = null;

        if (productModel.getMsrpPrice() != null) {
            msrpPrice = productModel.getMsrpPrice().doubleValue();
        }
        if (productModel.getPmatPrice() != null) {
            pmatPrice = productModel.getPmatPrice().doubleValue();
        }

        // Add this block in StoreProductPricePopulator.java within populate() method:
        if (msrpPrice == null || pmatPrice == null) {
            LOG.error("Missing price data (MSRP/PMAT) for product: " + productModel.getCode());
            // Optionally set default values or skip
            return;
        }

        target.setMsrpPrice(msrpPrice);
        target.setPmatPrice(pmatPrice);

        if (productModel.getCurrencyIsoCode() != null) {
            target.setCurrencyIsoCode(productModel.getCurrencyIsoCode());
        }

        if (productModel.getDiscount() != null) {
            target.setDiscount(productModel.getDiscount());
        }

        if (productModel.getPriceValidityStartDate() != null) {
            target.setPriceValidityStartDate(productModel.getPriceValidityStartDate());
        }

        if (productModel.getPriceValidityEndDate() != null) {
            target.setPriceValidityEndDate(productModel.getPriceValidityEndDate());
        }

        // Any other logic to be executed, e.g., logging, validations, etc.
    }
}
