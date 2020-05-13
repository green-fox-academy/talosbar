package com.greenfoxacademy.petshelter.services;

import com.greenfoxacademy.petshelter.models.Pet;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PetService {
  List<Pet> getAllPets();

  boolean hasOwner(Pet pet);
}
