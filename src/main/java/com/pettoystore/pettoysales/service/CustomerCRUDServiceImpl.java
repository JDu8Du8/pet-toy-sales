package com.pettoystore.pettoysales.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pettoystore.pettoysales.entities.Customer;
import com.pettoystore.pettoysales.repositories.CustomerRepository;


@Service
public class CustomerCRUDServiceImpl implements CustomerCRUDService {

  @Autowired
  CustomerRepository customerRepository;
  
  public CustomerCRUDServiceImpl (CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }
  
  @Override
  public List<Customer> getCustomers() {
    List<Customer> customers = new ArrayList<>();
    customerRepository.findAll().forEach(customers::add);
    return customers;
  }

  @Override
  public Customer getCustomerById(int id) {
    return customerRepository.findById(id).get();
  }

  @Override
  public Customer insertCustomer(String firstName, String lastName, String address) {
    Customer newCustomer = new Customer();
    newCustomer.setFirstName(firstName);
    newCustomer.setLastName(lastName);
    newCustomer.setAddress(address);
    customerRepository.save(newCustomer);
    return newCustomer;
  }

  @Override
  public void updateCustomer(Customer customer) {
    Customer customerFromDB = customerRepository.findById(customer.getCustomerID()).get();
    System.out.println(customerFromDB.toString());
    customerFromDB.setFirstName(customer.getFirstName());
    customerFromDB.setLastName(customer.getLastName());
    customerFromDB.setAddress(customer.getAddress());
    customerRepository.save(customer);

  }

  @Override
  public void deleteCustomer(int customerID) {
    customerRepository.deleteById(customerID);
  }

}
