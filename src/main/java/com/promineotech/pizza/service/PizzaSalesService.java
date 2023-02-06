package com.promineotech.pizza.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.pizza.entity.Pizza;
import com.promineotech.pizza.entity.PizzaSize;
import com.promineotech.pizza.entity.PizzaType;

public interface PizzaSalesService {
	
	/**
	 * 
	 * @param pizzaId
	 * @param pizzaSize
	 * @return
	 */
	List<Pizza> fetchPizza(String pizzaId, String pizzaSize);
	
	  Optional<Pizza> createPizza(String pizzaId, PizzaSize pizzaSize, PizzaType pizzaType);
	  
	  Optional<Pizza> updatePizza(String pizzaId, PizzaSize pizzaSize, PizzaSize newPizzaSize);

	  Optional<Pizza> deletePizza(String pizzaId, PizzaSize pizzaSize);



}
