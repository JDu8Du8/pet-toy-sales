package com.pettoystore.pettoysales.controllers;

import java.math.BigDecimal;
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
import com.pettoystore.pettoysales.entities.Toy;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/toys")
@Validated
@OpenAPIDefinition(info = @Info(title = "Pet Toy Store"), 
  servers = {@Server(url = "http://localhost:8080", 
  description = "Pet Toy Store" )})
public interface ToyControllerInterface {

  @Operation(
      summary = "Returns a list of Toys",
      description = "Returns a list of Toys",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "A list of Toys is returned", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Toy.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Toys Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
      )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
    List<Toy> getToys();
  
  @Operation(summary = "Get Toy by ID",
      description = "Get Toy by ID",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "A Toy is Returned", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Toy.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Toys Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      })
  @GetMapping({"/{toyID}"})
  public ResponseEntity<Toy> getToybyId(@Parameter (description = "ID of Toy to Find")
   @PathVariable int toyID);

  @Operation(summary = "Add a Toy",
      description = "Add a Toy",
      responses = {
          @ApiResponse(responseCode = "201", 
              description = "Toy Added", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Toy.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Toys Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
      )
  @PostMapping
  @Transactional
  @Validated
  public ResponseEntity<Toy> saveToy(@RequestParam String description, 
      @RequestParam int price);
  
//PUT
  @Operation(summary = "Update a Toy",
      description = "Update a Toy",
      responses = {
          @ApiResponse(responseCode = "202", 
              description = "Toy Updated", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Toy.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Toys Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
  ) 
  @PutMapping
  @Transactional
  public ResponseEntity<Toy> updateToy(@PathVariable("toyID") int toyID, @RequestBody Toy Toy);

//DELETE
  @Operation(summary = "Delete a Toy",
      description = "Delete a Toy",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "Toy Deleted"),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Toys Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
      ) 
  @DeleteMapping({"/{ToyID}"})
  public ResponseEntity<Toy> deleteToy(@Parameter (description = "ID of Toy to Delete")
   @PathVariable("ToyID") int ToyID);
}
