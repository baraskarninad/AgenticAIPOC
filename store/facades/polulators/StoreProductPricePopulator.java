// StoreProductPricePopulator.java
public class StoreProductPricePopulator {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(StoreProductPricePopulator.class);

    public void populate(Product source, ProductData target) {
        List<PriceRow> priceRows = source.getPriceRows();
        if (priceRows == null || priceRows.isEmpty()) {
            logger.error("Price rows are null or empty in StoreProductPricePopulator");
            target.setMsrpPrice(BigDecimal.ZERO);
            target.setPmatPrice(BigDecimal.ZERO);
            return;
        }
        BigDecimal msrpPrice = findMsrp(priceRows);
        BigDecimal pmatPrice = findPmat(priceRows);
        if (msrpPrice == null || pmatPrice == null) {
            logger.error("msrpPrice or PMATPrice price are null");
            target.setMsrpPrice(msrpPrice != null ? msrpPrice : BigDecimal.ZERO);
            target.setPmatPrice(pmatPrice != null ? pmatPrice : BigDecimal.ZERO);
            return;
        }
        target.setMsrpPrice(msrpPrice);
        target.setPmatPrice(pmatPrice);
    }

    // Assume these methods are properly implemented elsewhere.
    private BigDecimal findMsrp(List<PriceRow> priceRows) {
        // Implementation goes here
        return null;
    }

    private BigDecimal findPmat(List<PriceRow> priceRows) {
        // Implementation goes here
        return null;
    }
}
