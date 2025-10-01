public class StoreProductPricePopulator {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(StoreProductPricePopulator.class);

    public void populate(final ProductModel source, final ProductData target) {
        List<PriceRowModel> priceRows = fetchPriceRows(source);
        if (priceRows == null) {
            LOG.error("Price rows are null in StoreProductPricePopulator for product: {}", source != null ? source.getCode() : "null");
            return;
        }
        PriceModel msrpPrice = findMsrpPrice(priceRows);
        PriceModel pmatPrice = findPmatPrice(priceRows);
        if (msrpPrice == null || pmatPrice == null) {
            LOG.error("msrpPrice or PMATPrice price are null in StoreProductPricePopulator for product: {}", source != null ? source.getCode() : "null");
            // Optionally, set default values or handle accordingly
        }
        // ...rest of the population logic
    }

    // Placeholder methods for compilation
    private List<PriceRowModel> fetchPriceRows(ProductModel source) {
        // ...implementation
        return null;
    }
    private PriceModel findMsrpPrice(List<PriceRowModel> priceRows) {
        // ...implementation
        return null;
    }
    private PriceModel findPmatPrice(List<PriceRowModel> priceRows) {
        // ...implementation
        return null;
    }
}
