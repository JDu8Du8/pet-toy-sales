package com.pettoystore.pettoysales.controllers;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.pettoystore.pettoysales.entities.Breed;
import com.pettoystore.pettoysales.entities.Toy;
import com.pettoystore.pettoysales.service.BreedCRUDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BreedController implements BreedControllerInterface{
  
  
  @Autowired
  BreedCRUDService breedCRUDService;
  
  public BreedController(BreedCRUDService breedCRUDService) {
    this.breedCRUDService = breedCRUDService;
  }
  
  public List<Breed> getBreeds() {
    return breedCRUDService.getBreeds();
  }
  
  public ResponseEntity<Breed> getBreedbyId(int breedID){
    return new ResponseEntity<>(breedCRUDService.getBreedById(breedID), HttpStatus.OK);
  }
  
// Adds a Breed
  @Override
  public ResponseEntity<Breed> saveBreed(String description) {
    Breed newBreed = breedCRUDService.insertBreed(description);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(newBreed.getBreedID()).toUri();
    return ResponseEntity.created(location).build();
  }
  
  public ResponseEntity<Breed> updateBreed(Breed breed){
      breedCRUDService.updateBreed(breed);
      return new ResponseEntity<>(HttpStatus.OK);
  
  }
  
  public ResponseEntity<Breed> deleteBreed(int breedID){
    breedCRUDService.deleteBreed(breedID);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
