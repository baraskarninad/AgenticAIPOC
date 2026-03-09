package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import store.core.model.StoreProductModel;
import store.facades.data.StoreProductData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.math.BigDecimal;

@Component
public class StoreProductPricePopulator implements org.springframework.core.convert.converter.Converter<StoreProductModel, StoreProductData> {

    private static final Logger LOG = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    @Autowired
    public StoreProductPricePopulator() {
        // Default constructor
    }

    @Override
    public void convert(StoreProductModel source, StoreProductData target) {
        if (source == null) {
            LOG.error("Source StoreProductModel is null");
            return;
        }
        if (target == null) {
            LOG.error("Target StoreProductData is null");
            return;
        }

        BigDecimal msrpPrice = source.getMsrpPrice();
        BigDecimal pmatPrice = source.getPmatPrice();

        if (msrpPrice == null || pmatPrice == null) {
            LOG.error("msrpPrice or PMATPrice price are null for productCode: {}", source.getCode());
            target.setMsrpPrice(msrpPrice == null ? BigDecimal.ZERO : msrpPrice);
            target.setPmatPrice(pmatPrice == null ? BigDecimal.ZERO : pmatPrice);
            return;
        }

        target.setMsrpPrice(msrpPrice);
        target.setPmatPrice(pmatPrice);

        // Additional population of Other Price info (if any)
        if (source.getSalePrice() != null) {
            target.setSalePrice(source.getSalePrice());
        }
        if (source.getCostPrice() != null) {
            target.setCostPrice(source.getCostPrice());
        }
    }
}
```
