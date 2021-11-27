package com.pettoystore.pettoysales.service;

import java.util.List;
import com.pettoystore.pettoysales.entities.Dog;


public interface DogCRUDService {
  List<Dog> getDogs();

  Dog getDogById(int petID);

  Dog insertDog(Dog dog);

  void updateDog(int petID, Dog dog);

  void deleteDog(int petID);
}
