package com.promineotech.pizza.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.pizza.entity.Pizza;
import com.promineotech.pizza.entity.PizzaSize;
import com.promineotech.pizza.entity.PizzaType;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultPizzaSalesDao implements PizzaSalesDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Pizza> fetchPizza(String pizzaId, String pizzaSize) {
		log.debug("DAO: pizzaId={}, pizzaSize{}", pizzaId, pizzaSize);
		
		 //@formatter:off
	    String sql = ""
	        + "SELECT * "
	        + "FROM pizza "
	        + "WHERE pizza_id = :pizza_id AND pizza_size = :pizza_size";
	    //@formatter:on
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("pizza_id", pizzaId);
	    params.put("pizza_size", pizzaSize.toString()); 
	    //had to convert PizzaSize enum to String or else error occurs due to enum to String conversion
	    
	    return jdbcTemplate.query(sql, params, new RowMapper<>() {

	 //Mapping every column name to corresponding instance variables within Pizza table
	      @Override
	      public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
	        //@formatter:off
	        return Pizza.builder()
	            .pizzaPK(rs.getLong("Pizza_pk"))
	            .pizzaId(new String(rs.getString("pizza_Id")))
	            .pizzaSize(PizzaSize.valueOf(rs.getString("pizza_size")))
	            .pizzaType(PizzaType.valueOf(rs.getString("Pizza_type")))
	            .build();
	        //@formatter:on
	      }});
	  }
	 
	  @Override
	  public Optional<Pizza> createPizzas(String pizzaID, PizzaSize pizzaSize, PizzaType pizzaType) {
	    log.info("DAO: pizzaID={}, PizzaSize={}", pizzaID, pizzaSize);
	    
	    //@formatter:off
	    String sql = ""
	        + "INSERT INTO pizza ("
	        + "pizza_id, pizza_size, pizza_type"
	        + ") VALUES ("
	        +  ":pizza_Id, :pizza_size, :pizza_type)";
	    //@formatter:on
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("pizza_Id", pizzaID);
	    params.put("pizza_size", pizzaSize.toString()); 
	    params.put("pizza_type", pizzaType.toString()); 
	
	    
	    jdbcTemplate.update(sql, params);
	    return Optional.ofNullable(Pizza.builder().pizzaId(pizzaID).pizzaSize(pizzaSize).pizzaType(pizzaType).build());
	        }
	     

	  @Override
	  public Optional<Pizza> updatePizzas(String pizzaID, PizzaSize PizzaSize, PizzaSize newPizzaSize) {
	  log.info("DAO: pizzaID={}, PizzaSize={}", pizzaID, PizzaSize);
	  
	  //@formatter:off
	  String sql = ""
	      + "UPDATE Pizzas SET pizza_size = :new_pizza_size "
	      + "WHERE pizza_Id = :pizza_Id AND pizza_size = :pizza_size";
	  
	  // can add Pizza_type to update if switch savory vs sweet...need to recode params/sql
	  
	  //@formatter:on
	  
	  Map<String, Object> params = new HashMap<>();
	  params.put("pizza_Id", pizzaID);
	  params.put("pizza_size", PizzaSize.toString());
	  params.put("new_pizza_size", newPizzaSize.toString());

	  
	  jdbcTemplate.update(sql, params);
	  return Optional.ofNullable(Pizza.builder().pizzaId(pizzaID).pizzaSize(newPizzaSize).build());
	      }

	@Override
	public Optional<Pizza> deletePizzas(String pizzaID, PizzaSize pizzaSize) {
	  //@formatter:off
	  String sql = ""
	      + "DELETE FROM Pizzas WHERE "
	      + "pizza_Id = :pizza_Id AND "
	      + "pizza_size = :pizza_size";
	  //@formatter:on
	  
	  Map<String, Object> params = new HashMap<>();
	  params.put("pizza_Id", pizzaID);
	  params.put("pizza_size", pizzaSize.toString());

	  jdbcTemplate.update(sql, params); 

	  return Optional.ofNullable(Pizza.builder().pizzaId(pizzaID).pizzaSize(pizzaSize).build());
	  }
}

