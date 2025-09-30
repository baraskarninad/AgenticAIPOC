package store.facades.populators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import store.core.model.PriceRowModel;
import store.core.model.ProductModel;
import store.facades.data.StoreProductData;
import store.facades.data.StoreProductPriceData;
import store.platform.servicelayer.dto.converter.Populator;

import java.math.BigDecimal;
import java.util.List;

public class StoreProductPricePopulator implements Populator<ProductModel, StoreProductData> {

    private static final Logger log = LoggerFactory.getLogger(StoreProductPricePopulator.class);

    @Override
    public void populate(ProductModel source, StoreProductData target) {
        if (source == null || target == null) {
            log.error("Source or target is null");
            return;
        }

        StoreProductPriceData priceData = new StoreProductPriceData();

        PriceRowModel msrpPrice = getMSRPPrice(source.getPriceRows());
        PriceRowModel PMATPrice = getPMATPrice(source.getPriceRows());

        if (msrpPrice == null || PMATPrice == null) {
            log.error("msrpPrice or PMATPrice price are null");
            priceData.setPrice(BigDecimal.ZERO); // Provide default or skip
        } else {
            priceData.setPrice(msrpPrice.getValue());
        }

        // Handle null for priceRows similarly
        List<PriceRowModel> priceRows = source.getPriceRows();
        if (CollectionUtils.isEmpty(priceRows)) {
            log.error("priceRows are null or empty");
            priceData.setCurrency("USD"); // some default value
        } else {
            // extract currency from first priceRow for example
            priceData.setCurrency(priceRows.get(0).getCurrency().getIsocode());
        }

        target.setPriceData(priceData);
    }

    private PriceRowModel getMSRPPrice(List<PriceRowModel> priceRows) {
        if (CollectionUtils.isEmpty(priceRows)) {
            return null;
        }
        for (PriceRowModel priceRow : priceRows) {
            if ("MSRP".equalsIgnoreCase(priceRow.getPriceType())) {
                return priceRow;
            }
        }
        return null;
    }

    private PriceRowModel getPMATPrice(List<PriceRowModel> priceRows) {
        if (CollectionUtils.isEmpty(priceRows)) {
            return null;
        }
        for (PriceRowModel priceRow : priceRows) {
            if ("PMAT".equalsIgnoreCase(priceRow.getPriceType())) {
                return priceRow;
            }
        }
        return null;
    }
}
