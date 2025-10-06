/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package store.facades.populators;

import de.hybris.platform.commercefacades.product.PriceDataFactory;
import de.hybris.platform.commercefacades.product.converters.populator.ProductPricePopulator;
import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.commercefacades.product.data.PriceDataType;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.price.CommercePriceService;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.jalo.order.price.PriceInformation;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Required;

import com.store.b2b.core.constants.storeCoreConstants;

import javax.annotation.Resource;


/**
 * Populate the product data with the price information
 */
public class StoreProductPricePopulator<SOURCE extends ProductModel, TARGET extends ProductData>
		extends ProductPricePopulator<SOURCE, TARGET>
{
	private CommercePriceService commercePriceService;
	private PriceDataFactory priceDataFactory;
	private UserService userService;

	@Resource(name = "sessionService")
	private SessionService sessionService;

	@Override
	public void populate(final SOURCE productModel, final TARGET productData) throws ConversionException {
		final PriceDataType priceType = determinePriceType(productModel);
		final PriceInformation info = fetchPriceInformation(productModel, priceType);
		final boolean isAnonymousUser = userService.isAnonymousUser(userService.getCurrentUser());
		if (isTrackYourOrderPage()) {
			handleTrackYourOrderPage(info, priceType, productData);
		} else {
			handleRegularPrice(info, productModel, priceType, productData);
		}
		// adding price population logic for CCC-767 EU Pricing here, to keep the previous flow intact, -----
		// if in future price population logic is to be changes for anonymous user kindly make changes here,
		// for anonymous user listPrice is slashed price and price is the price on display for purchase,
		//some products are excluded check the flag PMATPrice


		if(isAnonymousUser && Boolean.TRUE.equals(productModel.getPMATPrice())){
			Collection<PriceRowModel> priceRows = productModel.getEurope1Prices();
				try{
				PriceRowModel msrpPrice = getMSRPPriceRow(priceRows);
				PriceRowModel PMATPrice = getPMATPriceRow(priceRows);
				
						PriceData listingPrice = priceDataFactory.create(priceType, BigDecimal.valueOf(msrpPrice.getPrice()), msrpPrice.getCurrency());
						PriceData price = priceDataFactory.create(priceType, BigDecimal.valueOf(PMATPrice.getPrice()), PMATPrice.getCurrency());

						productData.setListPrice(listingPrice);
						productData.setPrice(price);
					
				}
				catch(Exception e){
					LOG.error("msrpPrice or PMATPrice price are null ");
				}
			
		}
	}

}