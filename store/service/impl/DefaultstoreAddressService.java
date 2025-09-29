/*
 * [y] hybris Platform
 *
 * Copyright (c) 2020 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package com.store.service.impl;

import com.store.b2b.core.contracts.dao.storeAddressDao;
import com.store.b2b.core.customer.service.storeAddressService;
import com.store.b2b.core.user.storeUserService;
import com.store.b2b.model.B2BStorefrontPermissionModel;
import com.store.b2b.permissions.dao.StorefrontGroupPathDao;
import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.b2b.model.B2BUnitModel;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.servicelayer.user.impl.DefaultAddressService;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;
import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNullStandardMessage;


/**
 * Custom implementation of address service to implement store specific logic
 */
public class DefaultstoreAddressService extends DefaultAddressService implements storeAddressService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultstoreAddressService.class);

    private transient storeAddressDao storeAddressDao;
    private storeUserService storeUserService;
    private StorefrontGroupPathDao storefrontGroupPathDao;

    public DefaultstoreAddressService(final storeAddressDao storeAddressDao, final storeUserService storeUserService,
                                     final StorefrontGroupPathDao storefrontGroupPathDao) {
        setstoreAddressDao(storeAddressDao);
        setstoreUserService(storeUserService);
        setStorefrontGroupPathDao(storefrontGroupPathDao);
    }

    @Override
    public AddressModel findAddressByPublicKey(final String publicKey, final Boolean duplicate) {

        validateParameterNotNull(publicKey, "Parameter publicKey must not be null");
        AddressModel result = null;
        final List<AddressModel> addresses = getstoreAddressDao().findAddressByPublicKey(publicKey,
                duplicate);

        result = addresses.get(0);
        return result;

    }

    @Override
    public Optional<AddressModel> getDefaultAddressForCurrentCustomer() {
        return getstoreUserService().getCurrentUser() instanceof final B2BCustomerModel currentB2BCustomer ?
                getDefaultAddressForCustomer(currentB2BCustomer) : Optional.empty();
    }

    @Override
    public Optional<AddressModel> getDefaultAddressForCustomer(final B2BCustomerModel customer) {
        validateParameterNotNullStandardMessage("customer", customer);
        Optional<AddressModel> defaultAddress = Optional.empty();
        final B2BUnitModel defaultB2BUnit = customer.getDefaultB2BUnit();
        if (defaultB2BUnit != null) {
            final B2BStorefrontPermissionModel storefrontPermission = getStorefrontGroupPathDao()
                    .getStorefrontPermissionModel(customer, defaultB2BUnit);
            if (storefrontPermission != null) {
                defaultAddress = Optional.ofNullable(storefrontPermission.getDefaultAddress());
            }
        }
        return defaultAddress;
    }

    protected storeAddressDao getstoreAddressDao() {
        return storeAddressDao;
    }


    public void setstoreAddressDao(final storeAddressDao storeAddressDao) {
        this.storeAddressDao = storeAddressDao;
    }

    protected storeUserService getstoreUserService() {
        return storeUserService;
    }

    public void setstoreUserService(final storeUserService storeUserService) {
        this.storeUserService = storeUserService;
    }

    protected StorefrontGroupPathDao getStorefrontGroupPathDao() {
        return storefrontGroupPathDao;
    }

    public void setStorefrontGroupPathDao(final StorefrontGroupPathDao storefrontGroupPathDao) {
        this.storefrontGroupPathDao = storefrontGroupPathDao;
    }
}
