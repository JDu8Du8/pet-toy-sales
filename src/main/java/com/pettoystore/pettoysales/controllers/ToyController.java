package com.pettoystore.pettoysales.controllers;

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
import com.pettoystore.pettoysales.entities.Toy;
import com.pettoystore.pettoysales.service.ToyCRUDService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/toys")
@Slf4j
public class ToyController {
  
  @Autowired
  ToyCRUDService toyCRUDService;
  
  public ToyController(ToyCRUDService toyCRUDService) {
    this.toyCRUDService = toyCRUDService;
  }
  
  @GetMapping
  public ResponseEntity<List<Toy>> getAllToys() {
    List <Toy> toys = toyCRUDService.getToys();
    return new ResponseEntity<List<Toy>>(toys, HttpStatus.OK);
  }
  
  @GetMapping({"/{toyID}"})
  public ResponseEntity<Toy> getToy(@PathVariable int toyID){
    return new ResponseEntity<Toy>(toyCRUDService.getToyById(toyID), HttpStatus.OK);
  }
  
  @PostMapping(value="/toys")
  public ResponseEntity<Toy> saveToy(@RequestBody Toy toy) {
    Toy toy1 = toyCRUDService.insertToy(toy);
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("toy", "/api/v1/toy/" + toy1.getToyID());
    return new ResponseEntity<Toy>(toy1, httpHeaders, HttpStatus.CREATED);
  }
  
  @PutMapping({"/{toyID}"})
  public ResponseEntity<Toy> updateToy(@PathVariable("toyID") int toyID, 
    @RequestBody Toy toy){
      toyCRUDService.updateToy(toyID, toy);
      return new ResponseEntity<Toy>(toyCRUDService.getToyById(toyID), 
          HttpStatus.OK);
  
  }
  
  @DeleteMapping({"/{toyID}"})
  public ResponseEntity<Toy> deleteToy(@PathVariable("toyID") int toyID){
    toyCRUDService.deleteToy(toyID);
    return new ResponseEntity<Toy>(HttpStatus.NO_CONTENT);
  }
}
