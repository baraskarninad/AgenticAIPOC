public class StoreProductPricePopulator {

    public void populate(ProductModel source, ProductData target) {
        Double msrpPrice = source.getMsrpPrice();
        Double pmatPrice = source.getPmatPrice();
        List<PriceRowModel> priceRows = source.getPriceRows();

        // Null Check for msrpPrice and PMATPrice
        if (msrpPrice == null) {
            msrpPrice = 0.0;
            System.out.println("msrpPrice is null, defaulting to zero");
        }
        if (pmatPrice == null) {
            pmatPrice = 0.0;
            System.out.println("PMATPrice is null, defaulting to zero");
        }

        // Null check for priceRows
        if (priceRows == null) {
            priceRows = new ArrayList<>();
            System.out.println("Price rows are null, initializing to empty list");
        }

        target.setMsrpPrice(msrpPrice);
        target.setPmatPrice(pmatPrice);
        target.setPriceRows(priceRows);
    }
}