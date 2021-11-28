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
import com.pettoystore.pettoysales.entities.Dog;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/dogs")
@Validated
@OpenAPIDefinition(info = @Info(title = "Pet Toy Store"), 
  servers = {@Server(url = "http://localhost:8080", 
  description = "Pet Toy Store" )})
public interface DogControllerInterface {

  @Operation(
      summary = "Returns a list of Dogs",
      description = "Returns a list of Dogs",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "A list of Dogs is returned", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Dog.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Dogs Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
      )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
    List<Dog> getDogs();
  
  @Operation(summary = "Get Dog by ID",
      description = "Get Dog by ID",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "A Dog is Returned", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Dog.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Dogs Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      })
  @GetMapping({"/{dogID}"})
  public ResponseEntity<Dog> getDogbyId(@Parameter (description = "ID of Dog to Find")
   @PathVariable int dogID);

  @Operation(summary = "Add a Dog",
      description = "Add a Dog",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "Dog Added", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Dog.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Dogs Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
      )
  @PostMapping
  @Transactional
  @Validated
  public ResponseEntity<Dog> saveDog(@RequestParam int customerID, 
      @RequestParam int breedID, @RequestParam String name);
  
//PUT
  @Operation(summary = "Update a Dog",
      description = "Update a Dog",
      responses = {
          @ApiResponse(responseCode = "202", 
              description = "Dog Updated", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Dog.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Dogs Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
  ) 
  @PutMapping
  @Transactional
  public ResponseEntity<Dog> updateDog(@RequestBody Dog Dog);

//DELETE
  @Operation(summary = "Delete a Dog",
      description = "Delete a Dog",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "Dog Deleted"),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Dogs Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
      ) 
  @DeleteMapping({"/{dogID}"})
  public ResponseEntity<Dog> deleteDog(@Parameter (description = "ID of Dog to Delete")
   @PathVariable("dogID") int dogID);
}
