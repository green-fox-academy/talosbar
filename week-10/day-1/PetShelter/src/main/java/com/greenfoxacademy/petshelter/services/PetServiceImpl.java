package com.greenfoxacademy.petshelter.services;

import com.greenfoxacademy.petshelter.models.Human;
import com.greenfoxacademy.petshelter.models.Pet;
import com.greenfoxacademy.petshelter.repositories.PetRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

  @Override //????
  public List<Pet> getPetsWhichOwnerIsOlderThanGivenAge(int humanAge) {
    List<Pet> pets = new ArrayList<>();
    petRepository.getPetsWhichOwnerIsOlderThanGivenAge(humanAge).forEach(pets::add);
    return pets;
  }

  @Override
  public boolean hasOwner(Pet pet) {
    return pet.getOwner() != null;
  }

  @Override
  public boolean isPetNameAddedAlready(String petName) {
    Optional<Pet> foundPet = petRepository.findByPetName(petName);
    if (foundPet.isPresent()) {
      Pet pet = foundPet.get();
      return pet.getPetName().equals(petName);
    }
    return false;
  }

  @Override
  public void addPet(Pet pet) {
    petRepository.save(pet);
  }
}
