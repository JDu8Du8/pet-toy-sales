package com.pettoystore.pettoysales.service;

import java.util.List;
import com.pettoystore.pettoysales.entities.Dog;


public interface DogCRUDService {
  List<Dog> getDogs();

  Dog getDogById(int petID);

  Dog insertDog(int customerID, int breedID, String name);

  void updateDog(Dog dog);

  void deleteDog(int petID);
}
