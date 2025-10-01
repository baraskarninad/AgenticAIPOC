public class StoreProductPricePopulator {
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(StoreProductPricePopulator.class);

    public void populate(SourceProduct source, TargetProduct target) {
        PriceRows priceRows = source.getPriceRows();
        if (priceRows == null) {
            LOG.error("Price rows are null in StoreProductPricePopulator for productId: {}", source.getProductId());
            target.setMsrpPrice(0.0);
            target.setPmatPrice(0.0);
            return;
        }
        Double msrpPrice = priceRows.getMsrpPrice();
        Double pmatPrice = priceRows.getPmatPrice();
        if (msrpPrice == null || pmatPrice == null) {
            LOG.error("msrpPrice or PMATPrice price are null for productId: {}", source.getProductId());
            target.setMsrpPrice(msrpPrice != null ? msrpPrice : 0.0);
            target.setPmatPrice(pmatPrice != null ? pmatPrice : 0.0);
            return;
        }
        target.setMsrpPrice(msrpPrice);
        target.setPmatPrice(pmatPrice);
    }
}