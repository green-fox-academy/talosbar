package com.greenfoxacademy.petshelter.controllers;

import com.greenfoxacademy.petshelter.dtos.HumanDTO;
import com.greenfoxacademy.petshelter.models.Pet;
import com.greenfoxacademy.petshelter.services.HumanService;
import com.greenfoxacademy.petshelter.services.PetService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

  private HumanService humanService;
  private PetService petService;

  @Autowired
  public MainRestController(HumanService humanService,
                            PetService petService) {
    this.humanService = humanService;
    this.petService = petService;
  }

  @DeleteMapping("/delete/{humanId}") //a gombkent mukodo link nem tisztan ezt az urlt hozza
  public ResponseEntity<?> deleteHuman(@PathVariable long humanId) {
    if (humanService.findHumanById(humanId) != null) {
      humanService.deleteHuman(humanId);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>("No post at the given index" + humanId, HttpStatus.NOT_FOUND);
  }

  @PutMapping("/edit/{humanId}") //a gombkent mukodo link nem tisztan ezt az urlt hozza + jo a PUT??
  public ResponseEntity<?> editHuman(@PathVariable long humanId,
                                     @RequestParam("humanName") String humanName,
                                     @RequestParam("humanAge") int humanAge) {
    if (humanService.findHumanById(humanId) != null) {
      humanService.editHuman(humanId, humanName, humanAge);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>("No post at the given index" + humanId, HttpStatus.NOT_FOUND);
  }

  @GetMapping("/api/human/{humanId}")
  //bad requestnel vmiert nulla adattal adja ki az objectet, es 200-as kodot ir
  public ResponseEntity<?> getHumanById(@PathVariable long humanId) {
    if (humanService.findHumanById(humanId) != null) {
      return new ResponseEntity<>(humanService.findHumanById(humanId), HttpStatus.OK);
    }
    return new ResponseEntity<>(new Error("There is no human with the given " + humanId + "!"),
        HttpStatus.BAD_REQUEST);
  }

  @DeleteMapping("/api/human/{humanId}")
  public ResponseEntity<?> deleteHumanById(@PathVariable long humanId) {
    if (humanService.findHumanById(humanId) != null) {
      humanService.deleteHuman(humanId);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(new Error("There is no human with the given " + humanId + "!"),
        HttpStatus.BAD_REQUEST);
  }

  @PostMapping("/api/pet-names-older-human/")
  //hogy tegyem be a querybe az itt lekert parametert? hogy adjam vissza a petet?
  public ResponseEntity<?> getPetsWhichOwnerIsOlderThanGivenAge(@ModelAttribute int humanAge) {
    if (petService.getPetsWhichOwnerIsOlderThanGivenAge(humanAge) != null) {
      return new ResponseEntity<>(new Pet(), HttpStatus.OK);
    }
    return new ResponseEntity<>(
        new Error("None of the pets' owners are older then " + humanAge), HttpStatus.NOT_FOUND);
  }

  @PutMapping("/api/human/{id}") //DTO-ba nem kell entity, id stb annotation?
  public ResponseEntity<?> getHumanByGivenParameters(@PathVariable long humanId,
                                                     @RequestBody HumanDTO givenHuman) {
    HttpStatus status;

    try {
      humanService.getHumanByGivenParameters(humanId, givenHuman.getHumanName());
      status = HttpStatus.NO_CONTENT;
    } catch (IllegalArgumentException ex) {
      status = HttpStatus.FORBIDDEN;
    } catch (NotFoundException ex) {
      status = HttpStatus.NOT_FOUND;
    }
    return ResponseEntity.status(status).build();
  }
}
