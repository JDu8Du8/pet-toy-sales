package com.pettoystore.pettoysales.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pettoystore.pettoysales.entities.Breed;



@Repository
public interface BreedRepository extends CrudRepository<Breed, Integer>{

}
