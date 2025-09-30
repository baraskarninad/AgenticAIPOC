// StoreProductPricePopulator.java

import java.math.BigDecimal;
import java.util.List;

public class StoreProductPricePopulator {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(StoreProductPricePopulator.class);

    public void populate(SourceProductModel source, TargetProductData target) {
        List<PriceRowModel> priceRows = getPriceRows(source);
        if (priceRows == null || priceRows.isEmpty()) {
            LOG.error("Price rows are null or empty in StoreProductPricePopulator for product: {}", source.getCode());
            target.setMsrpPrice(getDefaultPrice());
            target.setPMATPrice(getDefaultPrice());
            return;
        }
        PriceData msrpPrice = getMsrpPrice(priceRows);
        PriceData pmatPrice = getPMATPrice(priceRows);
        if (msrpPrice == null || pmatPrice == null) {
            LOG.error("msrpPrice or PMATPrice price are null for product: {}", source.getCode());
            if (msrpPrice == null) {
                msrpPrice = getDefaultPrice();
            }
            if (pmatPrice == null) {
                pmatPrice = getDefaultPrice();
            }
        }
        if (msrpPrice != null) {
            target.setMsrpPrice(msrpPrice);
        } else {
            target.setMsrpPrice(getDefaultPrice());
        }
        if (pmatPrice != null) {
            target.setPMATPrice(pmatPrice);
        } else {
            target.setPMATPrice(getDefaultPrice());
        }
    }

    private PriceData getDefaultPrice() {
        PriceData defaultPrice = new PriceData();
        defaultPrice.setValue(BigDecimal.ZERO);
        defaultPrice.setCurrencyIso("USD");
        defaultPrice.setFormattedValue("$0.00");
        defaultPrice.setPriceType("DEFAULT");
        return defaultPrice;
    }

    // Dummy implementations for the sake of completeness
    private List<PriceRowModel> getPriceRows(SourceProductModel source) {
        // Implementation here
        return null;
    }

    private PriceData getMsrpPrice(List<PriceRowModel> priceRows) {
        // Implementation here
        return null;
    }

    private PriceData getPMATPrice(List<PriceRowModel> priceRows) {
        // Implementation here
        return null;
    }
}

// Dummy classes for completeness
class SourceProductModel {
    public String getCode() { return ""; }
}

class TargetProductData {
    public void setMsrpPrice(PriceData priceData) { }
    public void setPMATPrice(PriceData priceData) { }
}

class PriceRowModel { }

class PriceData {
    public void setValue(BigDecimal value) { }
    public void setCurrencyIso(String currencyIso) { }
    public void setFormattedValue(String formattedValue) { }
    public void setPriceType(String priceType) { }
}
