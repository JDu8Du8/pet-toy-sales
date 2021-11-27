package com.pettoystore.pettoysales.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pettoystore.pettoysales.entities.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>{

}
