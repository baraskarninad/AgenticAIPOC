package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import store.core.model.ProductModel;
import store.facades.data.ProductData;
import store.facades.data.PriceData;
import store.facades.data.CurrencyData;
import store.core.enums.PriceTypeEnum;

public class StoreProductPricePopulator {

    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    private PriceService priceService;

    public void populate(final ProductModel product, final ProductData target) {
        Assert.notNull(product, "Parameter product cannot be null.");
        Assert.notNull(target, "Parameter target cannot be null.");

        PriceData msrpPrice = null;
        PriceData pmatPrice = null;
        CurrencyData currency = null;

        if (product.getCurrency() != null) {
            currency = new CurrencyData();
            currency.setIsocode(product.getCurrency().getIsocode());
            target.setCurrency(currency);
        }

        if (product.getPrices() != null) {
            for (final PriceModel priceModel : product.getPrices()) {
                if (PriceTypeEnum.MSRP.equals(priceModel.getPriceType())) {
                    msrpPrice = priceService.createPriceData(priceModel);
                }
                if (PriceTypeEnum.PMAT.equals(priceModel.getPriceType())) {
                    pmatPrice = priceService.createPriceData(priceModel);
                }
            }
        }

        // Fix applied: Check for msrpPrice or pmatPrice null and log.
        if (msrpPrice == null || pmatPrice == null) {
            LOG.error("MSRP or PMAT price is null for product: {}", product != null ? product.getCode() : "unknown");
            // Optionally: set default price or inform frontend of missing data
            return;
        }

        target.setMsrpPrice(msrpPrice);
        target.setPmatPrice(pmatPrice);

        if (currency != null) {
            msrpPrice.setCurrencyIso(currency.getIsocode());
            pmatPrice.setCurrencyIso(currency.getIsocode());
        }
    }

    public void setPriceService(final PriceService priceService) {
        this.priceService = priceService;
    }
}
