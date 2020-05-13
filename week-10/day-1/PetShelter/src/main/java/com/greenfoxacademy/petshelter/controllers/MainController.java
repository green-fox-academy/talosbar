package com.greenfoxacademy.petshelter.controllers;

import com.greenfoxacademy.petshelter.models.Human;
import com.greenfoxacademy.petshelter.models.Pet;
import com.greenfoxacademy.petshelter.services.HumanService;
import com.greenfoxacademy.petshelter.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

  private HumanService humanService;
  private PetService petService;

  @Autowired
  public MainController(HumanService humanService,
                        PetService petService) {
    this.humanService = humanService;
    this.petService = petService;
  }

  @GetMapping(value = {"/", "/list-humans"})
  public String getListOfHumen(Model model) {
    model.addAttribute("humen", humanService.getAllHumen());
    return "list-humen";
  }

  @GetMapping("/list-pets") //jo itt a modelattribute? template-ben alahuzza vmiert a hasOwnert...
  public String getListOfPets(Model model,
                              @ModelAttribute Pet pet) {
    model.addAttribute("pets", petService.getAllPets());
    model.addAttribute("hasOwner", petService.hasOwner(pet));
    return "list-pets";
  }

  @GetMapping("/add-human") //hogyan kellene korabban elfogadott object adataival feltoltenem?
  public String editHuman(Model model, @RequestParam(required = false) Boolean invalidHumanData,
                          @ModelAttribute Human human) {
    model.addAttribute("invalidHumanData", invalidHumanData);
    model.addAttribute("human", new Human());
    return "edit";
  }

  @PostMapping("/add-human")
  //vmiert hozza akarja adni a mar letezo nevet is, es a query miatt exceptiont dob
  public String addNewHuman(@ModelAttribute Human human, RedirectAttributes attributes) {
    attributes.addFlashAttribute(human);
    if (humanService.isHumanNameAddedAlready(human.getHumanName())) {
      return "redirect:/add-human?invalidHumanData=true";
    } else {
      humanService.addHuman(human);
      return "edit";
    }
  }
}
