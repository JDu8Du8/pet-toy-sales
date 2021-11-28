package com.pettoystore.pettoysales.controllers;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.pettoystore.pettoysales.entities.Dog;
import com.pettoystore.pettoysales.service.DogCRUDService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/dogs")
@Slf4j
public class DogController implements DogControllerInterface{
  
  @Autowired
  DogCRUDService dogCRUDService;
  
  public DogController(DogCRUDService dogCRUDService) {
    this.dogCRUDService = dogCRUDService;
  }
  
  public List<Dog> getDogs() {
    return dogCRUDService.getDogs();
  }
  
  public ResponseEntity<Dog> getDogbyId(int dogID){
    return new ResponseEntity<>(dogCRUDService.getDogById(dogID), HttpStatus.OK);
  }
  
  public ResponseEntity<Dog> saveDog(int customerID, int breedID, String name) {
    Dog newDog = dogCRUDService.insertDog(customerID, breedID, name);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(newDog.getBreedID()).toUri();
    return ResponseEntity.created(location).build();
  }
  
  public ResponseEntity<Dog> updateDog(Dog dog){
      dogCRUDService.updateDog(dog);
      return new ResponseEntity<>(HttpStatus.OK);
  }
  
  public ResponseEntity<Dog> deleteDog(int dogID){
    dogCRUDService.deleteDog(dogID);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
