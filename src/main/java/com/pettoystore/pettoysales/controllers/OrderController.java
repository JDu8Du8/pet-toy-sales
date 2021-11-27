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
@RequestMapping("/orders")
@Slf4j
public class OrderController {
  
  @Autowired
  OrderCRUDService orderCRUDService;
  
  public OrderController(OrderCRUDService orderCRUDService) {
    this.orderCRUDService = orderCRUDService;
  }
  
  @GetMapping
  public ResponseEntity<List<Order>> getAllOrders() {
    List <Order> orders = orderCRUDService.getOrders();
    return new ResponseEntity<>(orders, HttpStatus.OK);
  }
  
  @GetMapping({"/{orderID}"})
  public ResponseEntity<Order> getOrder(@PathVariable int orderID){
    return new ResponseEntity<>(orderCRUDService.getOrderById(orderID), HttpStatus.OK);
  }
  
  
  public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
    Order order1 = orderCRUDService.insertOrder(order);
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("order", "/api/v1/order/" + order1.getOrderID());
    return new ResponseEntity<>(order1, httpHeaders, HttpStatus.CREATED);
  }
  
  @PutMapping({"/{orderID}"})
  public ResponseEntity<Order> updateOrder(@PathVariable("orderID") int orderID, 
    @RequestBody Order order){
      orderCRUDService.updateOrder(orderID, order);
      return new ResponseEntity<>(orderCRUDService.getOrderById(orderID), 
          HttpStatus.OK);
  
  }
  
  @DeleteMapping({"/{orderID}"})
  public ResponseEntity<Order> deleteOrder(@PathVariable("orderID") int orderID){
    orderCRUDService.deleteOrder(orderID);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
