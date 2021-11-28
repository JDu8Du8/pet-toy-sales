package com.pettoystore.pettoysales.service;

import java.util.List;
import com.pettoystore.pettoysales.entities.Customer;


public interface CustomerCRUDService {

  List<Customer> getCustomers();

  Customer getCustomerById(int id);

  Customer insertCustomer(String firstName, String lastName, String address);

  void updateCustomer(Customer Customer);

  void deleteCustomer(int CustomerID);
}
