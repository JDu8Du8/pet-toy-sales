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
import com.pettoystore.pettoysales.entities.Customer;
import com.pettoystore.pettoysales.service.CustomerCRUDService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController implements CustomerControllerInterface{
  
  @Autowired
  CustomerCRUDService customerCRUDService;
  
  public CustomerController(CustomerCRUDService customerCRUDService) {
    this.customerCRUDService = customerCRUDService;
  }
  
  public List<Customer> getCustomers() {
    return customerCRUDService.getCustomers();
  }
  
  public ResponseEntity<Customer> getCustomerbyId(int customerID){
    return new ResponseEntity<>(customerCRUDService.getCustomerById(customerID), HttpStatus.OK);
  }
  
  
  public ResponseEntity<Customer> saveCustomer(String firstName, 
      String lastName, String address) {
    Customer newCustomer = customerCRUDService.insertCustomer(firstName, lastName, address);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(newCustomer.getCustomerID()).toUri();
    return ResponseEntity.created(location).build();
  }
  
  public ResponseEntity<Customer> updateCustomer(Customer customer){
      customerCRUDService.updateCustomer(customer);
      return new ResponseEntity<>(HttpStatus.OK);
  
  }
  
  public ResponseEntity<Customer> deleteCustomer(int customerID){
    customerCRUDService.deleteCustomer(customerID);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
