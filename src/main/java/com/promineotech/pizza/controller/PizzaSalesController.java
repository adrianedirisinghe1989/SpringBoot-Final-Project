package com.promineotech.pizza.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.pizza.entity.Pizza;
import com.promineotech.pizza.entity.PizzaSize;
import com.promineotech.pizza.entity.PizzaType;

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
			summary = " Returns a Pizza ",
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

	 @Operation(
		      summary = "Creates a pizza",
		      description = "Create a pizza using a required pizza id and pizza size",
		      responses = {
		          @ApiResponse(
		              responseCode = "200", 
		              description = "A pizza is created!", 
		              content = @Content(
		                  mediaType = "application/json", 
		              schema = @Schema(implementation = Pizza.class))),
		          @ApiResponse(
		              responseCode = "400", 
		              description = "The request parameters are invalid.", 
		              content = @Content(
		                  mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "404", 
		              description = "Unable to create Pizza with the input criteria.", 
		              content = @Content(
		                  mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "500", 
		              description = "An unplanned error occurred.", 
		              content = @Content(
		                  mediaType = "application/json"))
		      },
		      parameters = {
		          @Parameter(
		              name = "pizzaId", 
		              allowEmptyValue = false, 
		              required = false, 
		              description = "The pizz type (i.e., 'SUPREME')"), 
		          @Parameter(
		              name = "PizzaSize",
		              allowEmptyValue = false,
		              required = false,
		              description = "The Pizza size (i.e., 'LARGE')"),
		          @Parameter(
		              name = "PizzaType",
		              allowEmptyValue = false,
		              required = false,
		              description = "The Pizza flavor (i.e., 'CHEESE')")
		      }
		  )
		  
		  // Post method (Create)
		  @PostMapping
		  @ResponseStatus(code = HttpStatus.CREATED)
		  Optional<Pizza> createPizzas(
		     @RequestParam(required = false) 
		     String pizzaId,
		     @RequestParam(required = false)
		     PizzaSize PizzaSize,
		     @RequestParam(required = false)
		     PizzaType PizzaType);  
		  
		  @Operation(
		      summary = "Updates a Pizza",
		      description = "Update a Pizza using a required Pizza, Pizza size, and Pizza type",
		      responses = {
		          @ApiResponse(
		              responseCode = "200", 
		              description = "A Pizza is updated!", 
		              content = @Content(
		                  mediaType = "application/json", 
		              schema = @Schema(implementation = Pizza.class))),
		          @ApiResponse(
		              responseCode = "400", 
		              description = "The request parameters are invalid.", 
		              content = @Content(
		                  mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "404", 
		              description = "Unable to update Pizza with the input criteria.", 
		              content = @Content(
		                  mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "500", 
		              description = "An unplanned error occurred.", 
		              content = @Content(
		                  mediaType = "application/json"))
		      },
		      parameters = {
		          @Parameter(
		              name = "pizzaId", 
		              allowEmptyValue = false, 
		              required = false, 
		              description = "The Pizza type (i.e., 'ALFERDO CHEESE')"), 
		          @Parameter(
		              name = "PizzaSize",
		              allowEmptyValue = false,
		              required = false,
		              description = "The Pizza size (i.e., 'LARGE')"),
		          @Parameter(
		              name = "PizzaType",
		              allowEmptyValue = false,
		              required = false,
		              description = "The Pizza flavor (i.e., 'ALFERDO')")
		      }
		  )
		  
		  // Put method (Update)
		 @PutMapping
		 @ResponseStatus(code = HttpStatus.OK)
		 Optional<Pizza> updatePizzas(
		     @RequestParam(required = false) 
		     String pizzaId,
		     @RequestParam(required = false)
		     PizzaSize PizzaSize,
		     @RequestParam(required = false)
		     PizzaSize newPizzaSize);
		  
		 @Operation(
		     summary = "Deletes a Pizza",
		     description = "Delete a Pizza given a required Pizza and Pizza size",
		     responses = {
		         @ApiResponse(
		             responseCode = "200", 
		             description = "A Pizza is deleted.", 
		             content = @Content(
		                 mediaType = "application/json", 
		             schema = @Schema(implementation = Pizza.class))),
		         @ApiResponse(
		             responseCode = "400", 
		             description = "The request parameters are invalid.", 
		             content = @Content(
		                 mediaType = "application/json")),
		         @ApiResponse(
		             responseCode = "404", 
		             description = "No Pizzas were found with the input criteria.", 
		             content = @Content(
		                 mediaType = "application/json")),
		         @ApiResponse(
		             responseCode = "500", 
		             description = "An unplanned error occurred.", 
		             content = @Content(
		                 mediaType = "application/json"))
		     },
		     parameters = {
		         @Parameter(
		             name = "pizzaId", 
		             allowEmptyValue = false, 
		             required = false, 
		             description = "The Pizza type (i.e., 'MEATBALL')"), 
		         @Parameter(
		             name = "PizzaSize",
		             allowEmptyValue = false,
		             required = false,
		             description = "The Pizza size (i.e., 'MEDIUM')") 
		     }
		 )
		  // Delete method (Delete)
		  @DeleteMapping
		  @ResponseStatus(code = HttpStatus.OK)
		  Optional<Pizza> deletePizzas(
		      @RequestParam(required = false) 
		      String pizzaId,
		      @RequestParam(required = false)
		      PizzaSize PizzaSize);
		  
		  //@formatter:on
		}


