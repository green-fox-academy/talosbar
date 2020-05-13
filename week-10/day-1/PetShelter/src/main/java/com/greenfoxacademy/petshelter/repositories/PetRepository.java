package com.greenfoxacademy.petshelter.repositories;

import com.greenfoxacademy.petshelter.models.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

}
