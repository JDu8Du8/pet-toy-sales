package com.pettoystore.pettoysales.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pettoystore.pettoysales.entities.Dog;

@Repository
public interface DogRepository extends CrudRepository<Dog, Integer>{

}
