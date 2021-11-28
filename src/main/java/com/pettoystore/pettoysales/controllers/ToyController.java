package com.pettoystore.pettoysales.controllers;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.pettoystore.pettoysales.entities.Toy;
import com.pettoystore.pettoysales.service.ToyCRUDService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/toys")
@Slf4j
public class ToyController implements ToyControllerInterface{
  
  @Autowired
  ToyCRUDService toyCRUDService;
  
  public ToyController(ToyCRUDService toyCRUDService) {
    this.toyCRUDService = toyCRUDService;
  }
  
  public List<Toy> getToys() {
    return toyCRUDService.getToys();
  }
  
  public ResponseEntity<Toy> getToybyId(int toyID){
    return new ResponseEntity<Toy>(toyCRUDService.getToyById(toyID), HttpStatus.OK);
  }
  
  public ResponseEntity<Toy> saveToy(String description, int price) {
    Toy newToy = toyCRUDService.insertToy(description, price);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(newToy.getToyID()).toUri();
    return ResponseEntity.created(location).build();
  }
  
  public ResponseEntity<Toy> updateToy(int toyID, Toy toy){
      toyCRUDService.updateToy(toyID, toy);
      return new ResponseEntity<Toy>(toyCRUDService.getToyById(toyID), 
          HttpStatus.OK);
  
  }
  
  public ResponseEntity<Toy> deleteToy(int toyID){
    toyCRUDService.deleteToy(toyID);
    return new ResponseEntity<Toy>(HttpStatus.NO_CONTENT);
  }


}
