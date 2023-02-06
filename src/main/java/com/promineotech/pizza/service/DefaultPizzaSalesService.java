package com.promineotech.pizza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.pizza.dao.PizzaSalesDao;
import com.promineotech.pizza.entity.Pizza;
import com.promineotech.pizza.entity.PizzaSize;
import com.promineotech.pizza.entity.PizzaType;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultPizzaSalesService implements PizzaSalesService {
	
	@Autowired
	private PizzaSalesDao pizzaSalesDao;
	

	@Override
	public List<Pizza> fetchPizza(String pizzaId, String pizzaSize){
		log.info("The fetchPizza method was called with pizzaId={} and pizzaSize{}",
				pizzaId, pizzaSize);
		
  return pizzaSalesDao.fetchPizza( pizzaId,  pizzaSize);
	}


	@Override
	public Optional<Pizza> createPizza(String pizzaId, PizzaSize pieSize, PizzaType pizzaType) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}


	@Override
	public Optional<Pizza> updatePizza(String pizzaId, PizzaSize pieSize, PizzaSize newPizzaSize) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}


	@Override
	public Optional<Pizza> deletePizza(String pizzaId, PizzaSize pizzaSize) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
}

	// Post (create pizza)
//	 @Override
//	 public Optional<Pizza> createPizza(String pizzaId, String pizzaSize, pizzaId pizzaType) {
//	   log.info("The createPies method was called with pizzaId={}, pizzaSize={}, pieType={}", pizzaId, pizzaSize, pizzaType); 
//	   
//	   return PizzaSalesDao.createPizza(pizzaId, pizzaSize, pizzaType); 
//	 }
//
//	// Put (update pies)
//	 @Override
//	 public Optional<Pizza> updatePizza(String pizzaId, PizzaSize pizzaSize, PizzaSize newpizzaSize) {
//	   log.info("The updatePies method was called with pizzaId={}, pizzaSize={}", pizzaId, pizzaSize); 
//	   
//	   return PizzaSalesDao.updatePizza(pizzaId, pizzaSize, newpizzaSize); 
//	 }
//
//	@Override
//	public Optional<Pizza> deletePizza(String pizzaId, PizzaSize pizzaSize) {
//	 
//	  return PizzaSalesDao.deletePizza(pizzaId, pizzaSize); 
//	}
//
//	}
//
	