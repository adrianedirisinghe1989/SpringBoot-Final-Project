package com.promineotech.pizza.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.pizza.entity.Address;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultAddressDao implements AddressDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  

  @Override
  public List<Address> fetchAddress(Long addressPK, String customerId) {
    log.info("DAO: addressPK={}, customerId={}", addressPK, customerId);

    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM address "
        + "WHERE address_pk = :address_pk AND customer_id = :customer_id";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("address_pk", addressPK.toString());
    params.put("customer_id", customerId); 
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {


   @Override
   public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return Address.builder()
            .addressPK(rs.getLong("address_pk"))
            .deliveryAddress(new String(rs.getString("delivery_address")))
            .build();
        //@formatter:on
      }});
  }

  @Override
  public Optional<Address> createAddress(String customerId, String billingAddress,
      String deliveryAddress) {
    log.info("DAO: customerId={}, billingAddress={}, deliveryAddress={}",
        customerId, billingAddress, deliveryAddress);
 
   //@formatter:off
   String sql = ""
     + "INSERT INTO address ("
     + "customer_id, billing_address, shipping_address"
     + ") VALUES ("
     +  ":customer_id, :billing_address, :shipping_address)";
   //@formatter:on
 
  Map<String, Object> params = new HashMap<>();
  params.put("customer_id", customerId);
  params.put("shipping_address", deliveryAddress); 

 jdbcTemplate.update(sql, params);
 return Optional.ofNullable(Address.builder()
     .deliveryAddress(deliveryAddress).build());
 }

  @Override
  public Optional<Address> updateAddress(Long addressPK, String customerId, String deliveryAddress) {
    log.info("DAO: addressPK={}, customerId={}, billingAddress={}, deliveryAddress={}", 
        addressPK, customerId, deliveryAddress);
    
    //@formatter:off
    String sql = ""
        + "UPDATE address SET billingAddress = :billing_address,"
        + "shipping_address = :shipping_address "
        + "WHERE addressPK = :addressPK AND "
        + "customerId = :customer_id AND "
        + "billingAddress = :billingAddress AND "
        + "deliveryAddress = :deliveryAddress";
    
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("address_pk", addressPK);
    params.put("customer_id", customerId);
    params.put("shipping_address", deliveryAddress); 
    
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Address.builder()
        .deliveryAddress(deliveryAddress).build());
  }

@Override
public Optional<Address> updateAddress(Long addressPK, String customerId, String billingAddress,
		String shippingAddress) {
	return Optional.empty();
}
}

	
