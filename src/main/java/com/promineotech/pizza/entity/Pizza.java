package com.promineotech.pizza.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Pizza {
	  private Long pizzaPK;
	  private String pizzaId;
	  private PizzaSize pizzaSize;
	  private PizzaType pizzaType;
}

