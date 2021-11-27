package com.pettoystore.pettoysales.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pettoystore.pettoysales.entities.Customer;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
