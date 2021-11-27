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
import com.pettoystore.pettoysales.entities.Breed;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/breeds")
@Validated
@OpenAPIDefinition(info = @Info(title = "Pet Toy Store"), 
  servers = {@Server(url = "http://localhost:8080", 
  description = "Pet Toy Store" )})
public interface BreedControllerInterface {

  @Operation(
      summary = "Returns a list of Breeds",
      description = "Returns a list of Breeds",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "A list of Breeds is returned", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Breed.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Breeds Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
      )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
    List<Breed> getBreeds();
  
  @Operation(summary = "Get Breed by ID",
      description = "Get Breed by ID",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "A Breed is Returned", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Breed.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Breeds Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      })
  @GetMapping({"/{breedID}"})
  public ResponseEntity<Breed> getBreedbyId(@Parameter (description = "ID of Breed to Find")
   @PathVariable int breedID);

  @Operation(summary = "Add a Breed",
      description = "Add a Breed",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "Breed Added", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Breed.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Breeds Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
      )
  @PostMapping
  public ResponseEntity<Breed> saveBreed(Breed breed);
  
//PUT
  @Operation(summary = "Update a Breed",
      description = "Update a Breed",
      responses = {
          @ApiResponse(responseCode = "202", 
              description = "Breed Updated", 
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Breed.class))),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Breeds Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
  ) 
  @PutMapping
  @Transactional
  public ResponseEntity<Breed> updateBreed(@RequestBody Breed breed);

//DELETE
  @Operation(summary = "Delete a Breed",
      description = "Delete a Breed",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "Breed Deleted"),
          @ApiResponse(responseCode = "400", 
          description = "Request Parameters Invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
          description = "No Breeds Found with Criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
      ) 
  @DeleteMapping({"/{breedID}"})
  public ResponseEntity<Breed> deleteBreed(@Parameter (description = "ID of Breed to Delete")
   @PathVariable("breedID") int breedID);
}
