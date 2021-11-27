package com.pettoystore.pettoysales.controllers;

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
import com.pettoystore.pettoysales.entities.Dog;
import com.pettoystore.pettoysales.service.DogCRUDService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/dogs")
@Slf4j
public class DogController {
  
  @Autowired
  DogCRUDService dogCRUDService;
  
  public DogController(DogCRUDService dogCRUDService) {
    this.dogCRUDService = dogCRUDService;
  }
  
  
  @GetMapping
  public ResponseEntity<List<Dog>> getAllDog() {
    List <Dog> dogs = dogCRUDService.getDogs();
    return new ResponseEntity<>(dogs, HttpStatus.OK);
  }
  
  @GetMapping({"/{dogID}"})
  public ResponseEntity<Dog> getDog(@PathVariable int dogID){
    return new ResponseEntity<>(dogCRUDService.getDogById(dogID), HttpStatus.OK);
  }
  
  public ResponseEntity<Dog> saveDog(@RequestBody Dog dog) {
    Dog dog1 = dogCRUDService.insertDog(dog);
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("dog", "/dog" + dog1.getPetID());
    return new ResponseEntity<>(dog1, httpHeaders, HttpStatus.CREATED);
  }
  
  @PutMapping({"/{dogID}"})
  public ResponseEntity<Dog> updateDog(@PathVariable("dogID") int dogID, 
    @RequestBody Dog dog){
      dogCRUDService.updateDog(dogID, dog);
      return new ResponseEntity<>(dogCRUDService.getDogById(dogID), 
          HttpStatus.OK);
  
  }
  
  @DeleteMapping({"/{dogID}"})
  public ResponseEntity<Dog> deleteDog(@PathVariable("dogID") int dogID){
    dogCRUDService.deleteDog(dogID);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
