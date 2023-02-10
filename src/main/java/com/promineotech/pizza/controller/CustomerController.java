package com.promineotech.pizza.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.pizza.entity.Customers;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Customers")
@OpenAPIDefinition(info = @Info(title = "PizzaSales Customer Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface CustomerController {
//@formatter:off
  @Operation(
      summary = "Returns a customer",
      description = "Returns a specific customer",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A  customer is returned.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Customers.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No customers were found with the input criteria.", 
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
              name = "customerPK", 
              allowEmptyValue = false, 
              required = false, 
              description = "The customerPK (i.e., '30')"), 
          @Parameter(
              name = "customerId",
              allowEmptyValue = false,
              required = false,
              description = "The customerId (i.e., 'Southbay310')") 
     }
  )
  
  // Get method (read)
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Customers> fetchCustomers(
      @RequestParam(required = false)
      Long customerPK, 
      @RequestParam(required = false)
      String customerId);

  @Operation(
      summary = "Creates a customer",
      description = "Create a customer using the required customer id, first name, "
          + "last name, and phone number.",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A customer is created!", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Customers.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Unable to create customer with the input criteria.", 
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
              name = "customerId", 
              allowEmptyValue = false, 
              required = false, 
              description = "The customer id (i.e., 'Josh')"), 
          @Parameter(
              name = "firstName",
              allowEmptyValue = false,
              required = false,
              description = "The first name (i.e., 'Emiy')"),
          @Parameter(
              name = "lastName",
              allowEmptyValue = false,
              required = false,
              description = "The last name (i.e., 'Smith')"),
          @Parameter(
              name = "phone",
              allowEmptyValue = false,
              required = false,
              description = "The phone number (i.e., '310-523-4568')")
      }
  )
 
  // Post method (create)
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Optional<Customers> createCustomers(
      @RequestParam(required = false)
      String customerId, 
      @RequestParam(required = false)
      String firstName,
      @RequestParam(required = false)
      String lastName, 
      @RequestParam(required = false)
      String phone);

  @Operation(
      summary = "Updates a customer",
      description = "Update a customer using the required customer id, first name, "
          + "last name, and phone number.",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A customer is updated!", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Customers.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Unable to update customer with the input criteria.", 
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
              name = "customerId", 
              allowEmptyValue = false, 
              required = false, 
              description = "The customer id (i.e., 'pizzalover310')"), 
          @Parameter(
              name = "firstName",
              allowEmptyValue = false,
              required = false,
              description = "The first name (i.e., 'Sammatha')"),
          @Parameter(
              name = "lastName",
              allowEmptyValue = false,
              required = false,
              description = "The last name (i.e., 'Baker')"),
          @Parameter(
              name = "phone",
              allowEmptyValue = false,
              required = false,
              description = "The phone number (i.e., '424-563-8952')")
      }
  )
  
  //Put method (update)
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Customers> updateCustomers(
      @RequestParam(required = false)
      String customerId,
      @RequestParam(required = false)
      String firstName,
      @RequestParam(required = false)
      String lastName,
      @RequestParam(required = false)
      String phone, 
      @RequestParam(required = false)
      String newFirstName, 
      @RequestParam(required = false)
      String newLastName, 
      @RequestParam(required = false)
      String newPhone);
}
