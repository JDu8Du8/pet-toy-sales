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
import com.pettoystore.pettoysales.entities.Customer;
import com.pettoystore.pettoysales.service.CustomerCRUDService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {
  
  @Autowired
  CustomerCRUDService customerCRUDService;
  
  public CustomerController(CustomerCRUDService customerCRUDService) {
    this.customerCRUDService = customerCRUDService;
  }
  
  @GetMapping
  public ResponseEntity<List<Customer>> getAllCustomers() {
    List <Customer> customers = customerCRUDService.getCustomers();
    return new ResponseEntity<>(customers, HttpStatus.OK);
  }
  
  
  @GetMapping({"/{custID}"})
  public ResponseEntity<Customer> getCustomer(@PathVariable int customerID){
    return new ResponseEntity<>(customerCRUDService.getCustomerById(customerID), HttpStatus.OK);
  }
  
  
  public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
    Customer customer1 = customerCRUDService.insertCustomer(customer);
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("customer", "/api/v1/customer/" + customer1.getCustomerID());
    return new ResponseEntity<>(customer1, httpHeaders, HttpStatus.CREATED);
  }
  
  @PutMapping({"/{customerID}"})
  public ResponseEntity<Customer> updateCustomer(@PathVariable("customerID") int customerID, 
    @RequestBody Customer customer){
      customerCRUDService.updateCustomer(customerID, customer);
      return new ResponseEntity<>(customerCRUDService.getCustomerById(customerID), 
          HttpStatus.OK);
  
  }
  
  @DeleteMapping({"/{customerID}"})
  public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerID") int customerID){
    customerCRUDService.deleteCustomer(customerID);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
