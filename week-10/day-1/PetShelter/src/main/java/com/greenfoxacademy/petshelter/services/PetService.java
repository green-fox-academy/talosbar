package com.greenfoxacademy.petshelter.services;

import com.greenfoxacademy.petshelter.models.Pet;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PetService {
  List<Pet> getAllPets();

  List<Pet> getPetsWhichOwnerIsOlderThanGivenAge(int humanAge);

  boolean hasOwner(Pet pet);

  boolean isPetNameAddedAlready(String petName);

  void addPet(Pet pet);
}
