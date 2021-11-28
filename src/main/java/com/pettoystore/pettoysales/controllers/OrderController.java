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
import com.pettoystore.pettoysales.entities.Order;
import com.pettoystore.pettoysales.service.OrderCRUDService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OrderController implements OrderControllerInterface{
  
  @Autowired
  OrderCRUDService orderCRUDService;
  
  public OrderController(OrderCRUDService orderCRUDService) {
    this.orderCRUDService = orderCRUDService;
  }
  
  public List<Order> getOrders() {
    return orderCRUDService.getOrders();
  }
  
  public ResponseEntity<Order> getOrderbyId(int orderID){
    return new ResponseEntity<>(orderCRUDService.getOrderById(orderID), HttpStatus.OK);
  }
  
  
  public ResponseEntity<Order> saveOrder(Order order) {
    Order order1 = orderCRUDService.insertOrder(order);
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("order", "/api/v1/order/" + order1.getOrderID());
    return new ResponseEntity<>(order1, httpHeaders, HttpStatus.CREATED);
  }
  
  public ResponseEntity<Order> updateOrder(Order order){
      orderCRUDService.updateOrder(order);
      return new ResponseEntity<>(HttpStatus.OK);
  
  }
  
  public ResponseEntity<Order> deleteOrder(int orderID){
    orderCRUDService.deleteOrder(orderID);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
