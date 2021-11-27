package com.pettoystore.pettoysales.service;

import java.util.List;
import com.pettoystore.pettoysales.entities.Breed;



public interface BreedCRUDService {
  List<Breed> getBreeds();

  Breed getBreedById(int id);

  Breed insertBreed(Breed breed);

  public void updateBreed(Breed breed);

  void deleteBreed(int breedID);
}
