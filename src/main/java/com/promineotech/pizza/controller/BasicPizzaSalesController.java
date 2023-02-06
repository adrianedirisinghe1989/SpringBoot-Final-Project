package com.promineotech.pizza.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.pizza.entity.Pizza;
import com.promineotech.pizza.service.PizzaSalesService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicPizzaSalesController implements PizzaSalesController {
	
	@Autowired
	private PizzaSalesService pizzaSalesService;

	@Override
	public List<Pizza> fetchPizza (String pizzaId, String pizzaSize){
	log.debug("pizzaId{}, pizzaSize{}", pizzaId, pizzaSize);
		return pizzaSalesService.fetchPizza(pizzaId,pizzaSize);
	}
}
