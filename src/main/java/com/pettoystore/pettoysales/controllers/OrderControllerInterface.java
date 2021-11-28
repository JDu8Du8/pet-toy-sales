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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.pettoystore.pettoysales.entities.Order;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/orders")
@Validated
@OpenAPIDefinition(info = @Info(title = "Pet Toy Store"), 
  servers = {@Server(url = "http://localhost:8080", 
  description = "Pet Toy Store" )})
public interface OrderControllerInterface {

  @Operation(
      summary = "Returns a list of Orders",
      description = "Returns a list of Orders",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "A list of Orders is returned", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Order.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Orders Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
      )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
    List<Order> getOrders();
  
  @Operation(summary = "Get Order by ID",
      description = "Get Order by ID",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "A Order is Returned", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Order.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Orders Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      })
  @GetMapping({"/{orderID}"})
  public ResponseEntity<Order> getOrderbyId(@Parameter (description = "ID of Order to Find")
   @PathVariable int orderID);

  @Operation(summary = "Add an Order",
      description = "Add an Order",
      responses = {
          @ApiResponse(responseCode = "201", 
              description = "Order Added", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Order.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Orders Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
      )
  @PostMapping
  @Transactional
  @Validated
  public ResponseEntity<Order> saveOrder(@RequestBody Order order);
  
//PUT
  @Operation(summary = "Update a Order",
      description = "Update a Order",
      responses = {
          @ApiResponse(responseCode = "202", 
              description = "Order Updated", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Order.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Orders Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
  ) 
  @PutMapping
  @Transactional
  public ResponseEntity<Order> updateOrder(@RequestBody Order order);

//DELETE
  @Operation(summary = "Delete a Order",
      description = "Delete a Order",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "Order Deleted"),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Orders Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
      ) 
  @DeleteMapping({"/{orderID}"})
  public ResponseEntity<Order> deleteOrder(@Parameter (description = "ID of Order to Delete")
   @PathVariable("orderID") int orderID);
}
