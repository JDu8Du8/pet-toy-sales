package com.pettoystore.pettoysales.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.http.ResponseEntity;
import com.pettoystore.pettoysales.entities.Toy;

public interface ToyCRUDService {
  List<Toy> getToys();

  Toy getToyById(int id);

  Toy insertToy(String description, int price);

  void updateToy(int id, Toy toy);

  void deleteToy(int toyID);
}
