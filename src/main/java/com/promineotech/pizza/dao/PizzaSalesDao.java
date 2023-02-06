package com.promineotech.pizza.dao;

import java.util.List;
import java.util.Optional;

import com.promineotech.pizza.entity.Pizza;
import com.promineotech.pizza.entity.PizzaSize;
import com.promineotech.pizza.entity.PizzaType;

public interface PizzaSalesDao {


	
/**
 * 
 * @param pizzaId
 * @param pizzaSize
 * @return
 */


	Optional<Pizza> deletePizzas(String pizzaID, PizzaSize pizzaSize);

	Optional<Pizza> updatePizzas(String pizzaID, PizzaSize PizzaSize, PizzaSize newPizzaSize);

	Optional<Pizza> createPizzas(String pizzaID, PizzaSize pizzaSize, PizzaType pizzaType);

	List<Pizza> fetchPizza(String pizzaId, String pizzaSize);


}
