package com.promineotech.pizza.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.pizza.entity.Pizza;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;




@RequestMapping("/Pizza")
@OpenAPIDefinition(info= @Info(title= "Pizza Sales Service"), servers = {
		@Server(url ="http://localhost:8080", description = "Local server.")})

public interface PizzaSalesController {

	//@formatter:off
	@Operation(
			summary = " Returns a list of Pizzas ",
			description = "Returns a list of pizza given a pizzaId",
			responses = {
					@ApiResponse(
							responseCode ="200", 
							description = "A list of pizzas are returned", content = @Content(mediaType = "application/json", 
							schema = @Schema(implementation = Pizza.class))),
					@ApiResponse(
							responseCode ="400", 
							description = "The request parameters are invalid",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode ="404", 
							description = "No trails were found with the input criteria",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode ="500", 
							description = "An unplanned error occurred.", 
						content = @Content(mediaType = "application/json"))
			},
			parameters = {
			@Parameter(
					name= "pizzaId", 
					allowEmptyValue =false, 
					required = false, 
					description ="The pizza name(i.e, 'CHICKEN MUSHROOM')"),
			@Parameter(
					name= "pizzaSize", 
					allowEmptyValue =false, 
					required = false,
					description ="The pizza size (i.e, 'SMALL')" )		
			})
			

	@GetMapping
	@ResponseStatus (code =HttpStatus.OK)
	List<Pizza> fetchPizza(
			@RequestParam(required = false) 
			String pizzaId,
			@RequestParam(required =false) 
			String pizzaSize );
	//@formatter:on 
}	

