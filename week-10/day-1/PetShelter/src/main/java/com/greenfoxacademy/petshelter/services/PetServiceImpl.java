package com.greenfoxacademy.petshelter.services;

import com.greenfoxacademy.petshelter.models.Pet;
import com.greenfoxacademy.petshelter.repositories.PetRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {

  PetRepository petRepository;

  @Autowired
  public PetServiceImpl(PetRepository petRepository) {
    this.petRepository = petRepository;
  }

  @Override
  public List<Pet> getAllPets() {
    List<Pet> pets = new ArrayList<>();
    petRepository.findAll().forEach(pets::add);
    return pets;
  }

  @Override
  public boolean hasOwner(Pet pet) {
    return pet.getOwner() != null;
  }
}
