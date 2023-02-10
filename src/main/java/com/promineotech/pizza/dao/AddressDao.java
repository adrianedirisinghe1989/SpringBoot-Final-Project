package com.promineotech.pizza.dao;

import java.util.List;
import java.util.Optional;

import com.promineotech.pizza.entity.Address;

public interface AddressDao {

	List<Address> fetchAddress(Long addressPK, String customerId);

	Optional<Address> createAddress(String customerId, String billingAddress, String shippingAddress);

	Optional<Address> updateAddress(Long addressPK, String customerId, String billingAddress, String shippingAddress);

	Optional<Address> updateAddress(Long addressPK, String customerId, String deliveryAddress);

	Optional<Address> deleteAddress(Long addressPK, String customerId, String billingAddress, String shippingAddress);

}
