package com.pettoystore.pettoysales.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pettoystore.pettoysales.entities.Dog;
import com.pettoystore.pettoysales.repositories.DogRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DogCRUDServiceImpl implements DogCRUDService {

  @Autowired
  DogRepository dogRepository;
  
  /*
  @Autowired
  private DefaultDogDao dogDao;
  */
  
  @Autowired
  public DogCRUDServiceImpl (DogRepository dogRepository) {
    this.dogRepository = dogRepository;
  }
  
  @Override
  public List<Dog> getDogs() {
    List<Dog> dogs = new ArrayList<>();
    dogRepository.findAll().forEach(dogs::add);
    return dogs;
  }

  @Override
  public Dog getDogById(int petID) {
    return dogRepository.findById(petID).get();
  }

  @Override
  public Dog insertDog(Dog dog) {
    
    return dogRepository.save(dog);
  }

  @Override
  public void updateDog(int petID, Dog dog) {
    Dog dogFromDB = dogRepository.findById(petID).get();
    System.out.println(dogFromDB.toString());
    dogFromDB.setBreedID(dog.getBreedID());
    dogFromDB.setCustomerID(dog.getCustomerID());
    dogFromDB.setName(dog.getName());
    dogRepository.save(dog);
  }

  @Override
  public void deleteDog(int petID) {
    dogRepository.deleteById(petID);

  }

}
