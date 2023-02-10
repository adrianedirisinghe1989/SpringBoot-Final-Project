package com.promineotech.pizza.service;

import java.util.List;
import java.util.Optional;

import com.promineotech.pizza.entity.Address;
import com.promineotech.pizza.entity.Pizza;
import com.promineotech.pizza.entity.PizzaSize;



public interface AddressService {

/**
 * 
 * @param addressPK
 * @param customerId
 * @return
 */
  List<Address> fetchAddress(Long addressPK, String customerId);

  Optional<Address> createAddress(String customerId, String billingAddress,
      int customerFk);



Optional<Address> deleteAdress(Long addressPK, String customerId, String billingAddress, String shippingAddress);

Optional<Address> updateAddress(Long addressPK, String customerId, String billingAddress, String shippingAddress);

Optional<Address> createAddress(String customerId, String billingAddress, String shippingAddress);


}
