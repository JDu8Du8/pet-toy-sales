package com.pettoystore.pettoysales.service;

import java.util.List;
import com.pettoystore.pettoysales.entities.Order;

public interface OrderCRUDService {
  List<Order> getOrders();

  Order getOrderById(int id);

  Order insertOrder(Order order);

  void updateOrder(int id, Order order);

  void deleteOrder(int orderID);
}
