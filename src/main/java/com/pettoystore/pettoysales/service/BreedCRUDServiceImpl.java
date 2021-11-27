package com.pettoystore.pettoysales.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pettoystore.pettoysales.entities.Breed;
import com.pettoystore.pettoysales.repositories.BreedRepository;

@Service
public class BreedCRUDServiceImpl implements BreedCRUDService {

  @Autowired 
  BreedRepository breedRepository;
  
  
  public BreedCRUDServiceImpl (BreedRepository breedRepository) {
    this.breedRepository = breedRepository;
  }
  
  @Override
  public List<Breed> getBreeds() {
    List<Breed> breeds = new ArrayList<>();
    breedRepository.findAll().forEach(breeds::add);
    return breeds;
  }

  @Override
  public Breed getBreedById(int id) {
    return breedRepository.findById(id).get();
  }

  @Override
  public Breed insertBreed(Breed breed) 
  {
    return breedRepository.save(breed);
  }

  @Override
  public void updateBreed(Breed breed) {
    Breed breedFromDB = breedRepository.findById(breed.getBreedID()).get();
    System.out.println(breedFromDB.toString());
    breedFromDB.setDescription(breed.getDescription());
    breedRepository.save(breedFromDB);
  }

  @Override
  public void deleteBreed(int breedID) {
    breedRepository.deleteById(breedID);
  }

}
