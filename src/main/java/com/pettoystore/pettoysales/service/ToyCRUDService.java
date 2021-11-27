package com.pettoystore.pettoysales.service;

import java.util.List;
import com.pettoystore.pettoysales.entities.Toy;

public interface ToyCRUDService {
  List<Toy> getToys();

  Toy getToyById(int id);

  Toy insertToy(Toy toy);

  void updateToy(int id, Toy toy);

  void deleteToy(int toyID);
}
