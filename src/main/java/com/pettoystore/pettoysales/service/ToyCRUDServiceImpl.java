package com.pettoystore.pettoysales.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pettoystore.pettoysales.entities.Toy;
import com.pettoystore.pettoysales.repositories.ToyRepository;

@Service
public class ToyCRUDServiceImpl implements ToyCRUDService {

  @Autowired  
  ToyRepository toyRepository;
  
  public ToyCRUDServiceImpl (ToyRepository toyRepository) {
    this.toyRepository = toyRepository;
  }
  
  @Override
  public List<Toy> getToys() {
    List<Toy> toys = new ArrayList<>();
    toyRepository.findAll().forEach(toys::add);
    return toys;
  }

  @Override
  public Toy getToyById(int id) {
    return toyRepository.findById(id).get();
  }

  @Override
  public Toy insertToy(String description, int price) {
    Toy newToy = new Toy();
    newToy.setDescription(description);
    newToy.setPrice(price);
    toyRepository.save(newToy);
    return newToy;
  }

  @Override
  public void updateToy(int id, Toy toy) {
    Toy toyFromDB = toyRepository.findById(id).get();
    System.out.println(toyFromDB.toString());
    toyFromDB.setDescription(toy.getDescription());
    toyRepository.save(toy);

  }

  @Override
  public void deleteToy(int toyID) {
    toyRepository.deleteById(toyID);
  }

}
