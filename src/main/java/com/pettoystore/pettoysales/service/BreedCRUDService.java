package com.pettoystore.pettoysales.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.pettoystore.pettoysales.entities.Breed;



public interface BreedCRUDService {
  List<Breed> getBreeds();

  Breed getBreedById(int id);

  Breed insertBreed(String description);

  public void updateBreed(Breed breed);

  void deleteBreed(int breedID);
}
