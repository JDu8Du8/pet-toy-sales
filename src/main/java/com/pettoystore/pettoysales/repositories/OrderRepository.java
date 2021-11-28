package com.pettoystore.pettoysales.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pettoystore.pettoysales.entities.Order;
import com.pettoystore.pettoysales.entities.Toy;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>{

  List<Order> findByOrderIDContaining(int orderID);
}
