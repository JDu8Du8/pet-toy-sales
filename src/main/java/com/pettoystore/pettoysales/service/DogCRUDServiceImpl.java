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
  public Dog insertDog(int customerID, int breedID, String name) {
    Dog newDog = new Dog();
    newDog.setCustomerID(breedID);
    newDog.setBreedID(breedID);
    newDog.setName(name);
    dogRepository.save(newDog);
    return newDog;
  }

  @Override
  public void updateDog(Dog dog) {
    Dog dogFromDB = dogRepository.findById(dog.getPetID()).get();
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
