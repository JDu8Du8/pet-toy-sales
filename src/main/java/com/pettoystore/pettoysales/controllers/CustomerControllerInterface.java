package com.pettoystore.pettoysales.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.pettoystore.pettoysales.entities.Customer;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/customers")
@Validated
@OpenAPIDefinition(info = @Info(title = "Pet Toy Store"), 
  servers = {@Server(url = "http://localhost:8080", 
  description = "Pet Toy Store" )})
public interface CustomerControllerInterface {

  @Operation(
      summary = "Returns a list of Customers",
      description = "Returns a list of Customers",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "A list of Customers is returned", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Customer.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Customers Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
      )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
    List<Customer> getCustomers();
  
  @Operation(summary = "Get Customer by ID",
      description = "Get Customer by ID",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "A Customer is Returned", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Customer.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Customers Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      })
  @GetMapping({"/{customerID}"})
  public ResponseEntity<Customer> getCustomerbyId(@Parameter (description = "ID of Customer to Find")
   @PathVariable int customerID);

  @Operation(summary = "Add a Customer",
      description = "Add a Customer",
      responses = {
          @ApiResponse(responseCode = "201", 
              description = "Customer Added", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Customer.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Customers Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
      )
  @PostMapping
  @Transactional
  @Validated
  public ResponseEntity<Customer> saveCustomer(@RequestParam String first_name,
      @RequestParam String last_name, @RequestParam String address);
  
//PUT
  @Operation(summary = "Update a Customer",
      description = "Update a Customer",
      responses = {
          @ApiResponse(responseCode = "202", 
              description = "Customer Updated", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Customer.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Customers Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
  ) 
  @PutMapping
  @Transactional
  public ResponseEntity<Customer> updateCustomer(@RequestBody Customer Customer);

//DELETE
  @Operation(summary = "Delete a Customer",
      description = "Delete a Customer",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "Customer Deleted"),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Customers Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
      ) 
  @DeleteMapping({"/{customerID}"})
  public ResponseEntity<Customer> deleteCustomer(@Parameter (description = "ID of Customer to Delete")
   @PathVariable("customerID") int CustomerID);
}
