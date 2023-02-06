package com.promineotech.pizza.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

  private Long orderPK;
  private OrderStatus orderItem;
  private Customers customer;
  private BigDecimal orderTotal;

}
