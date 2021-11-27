package com.pettoystore.pettoysales.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pettoystore.pettoysales.entities.Order;
import com.pettoystore.pettoysales.repositories.OrderRepository;

@Service
public class OrderCRUDServiceImpl implements OrderCRUDService {

  @Autowired
  OrderRepository orderRepository;
  
  public OrderCRUDServiceImpl (OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }
  
  @Override
  public List<Order> getOrders() {
    List<Order> orders = new ArrayList<>();
    orderRepository.findAll().forEach(orders::add);
    return orders;
  }

  @Override
  public Order getOrderById(int id) {
    return orderRepository.findById(id).get();
  }

  @Override
  public Order insertOrder(Order order) {
    return orderRepository.save(order);
  }

  @Override
  public void updateOrder(int id, Order order) {
    Order orderFromDB = orderRepository.findById(id).get();
    System.out.println(orderFromDB.toString());
    orderFromDB.setCustID(order.getCustID());
    orderFromDB.setToyID(order.getToyID());
    orderFromDB.setQuantity(order.getQuantity());
    orderFromDB.setTotal(order.getTotal());
    orderRepository.save(order);

  }

  @Override
  public void deleteOrder(int orderID) {
    orderRepository.deleteById(orderID);
  }

}
