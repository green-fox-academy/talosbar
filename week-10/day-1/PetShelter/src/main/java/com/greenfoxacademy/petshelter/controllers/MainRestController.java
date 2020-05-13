package com.greenfoxacademy.petshelter.controllers;

import com.greenfoxacademy.petshelter.services.HumanService;
import com.greenfoxacademy.petshelter.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
      return ResponseEntity.ok(humanService.findHumanById(humanId));
    }
    return ResponseEntity.badRequest()
        .body(new Error("There is no human with the given " + humanId + "!"));
  }

  @DeleteMapping("/api/human/{humanId}")
  public ResponseEntity<?> deleteHumanById(@PathVariable long humanId) {
    if (humanService.findHumanById(humanId) != null) {
      humanService.deleteHuman(humanId);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return ResponseEntity.badRequest()
        .body(new Error("There is no human with the given " + humanId + "!"));
  }
}
