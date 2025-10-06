package store.facades.populators;

import org.apache.log4j.Logger;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

// Assuming these are your domain/model classes
import store.model.SourceType;
import store.dto.TargetType;

public class StoreProductPricePopulator implements Populator<SourceType, TargetType> {

    private static final Logger LOG = Logger.getLogger(StoreProductPricePopulator.class);

    @Override
    public void populate(final SourceType source, final TargetType target) throws ConversionException {
        if (source == null) {
            throw new IllegalArgumentException("Parameter source cannot be null.");
        }
        if (target == null) {
            throw new IllegalArgumentException("Parameter target cannot be null.");
        }
        
        // Example of copying simple fields
        target.setId(source.getId());
        target.setName(source.getName());
        target.setDescription(source.getDescription());

        // Existing/Legacy logic for price population
        if (source.getPriceRows() == null) {
            LOG.warn("Price rows are null in StoreProductPricePopulator");
            target.setPriceRows(Collections.emptyList()); // FIX: set default empty list instead of returning early
        } else {
            target.setPriceRows(source.getPriceRows());
        }

        // Other field mappings
        target.setAvailable(source.isAvailable());
        target.setCategories(source.getCategories());
        target.setBrand(source.getBrand());

        // Additional logic that may come after price row processing
        if (source.getAttributes() != null && !source.getAttributes().isEmpty()) {
            target.setAttributes(source.getAttributes());
        }

        // Handle images if available
        if (source.getImageUrls() != null) {
            target.setImageUrls(source.getImageUrls());
        }
    }
}
```
