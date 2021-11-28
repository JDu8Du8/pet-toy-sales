package com.pettoystore.pettoysales.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pettoystore.pettoysales.entities.Toy;

@Repository
public interface ToyRepository extends CrudRepository<Toy, Integer> {

  List<Toy> findByToyIDContaining(int toyID);
}
