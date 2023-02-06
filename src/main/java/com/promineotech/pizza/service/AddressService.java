package com.promineotech.pizza.service;

import java.util.List;
import java.util.Optional;

import com.promineotech.pizza.entity.Address;



public interface AddressService {

  /**
   * 
   * @param addressPK
   * @param customerId
   * @return
   */
  List<Address> fetchAddress(Long addressPK, String customerId);

  Optional<Address> createAddress(String customerId, String billingAddress,
      String shippingAddress);

  Optional<Address> updateAddress(Long addressPK, String customerId, String billingAddress,
      String shippingAddress);
}
