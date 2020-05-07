package com.greenfoxacademy.basics.controllers;

import com.greenfoxacademy.basics.models.Greeting;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicsController {

  Greeting greeting = new Greeting(1, "Hello World!");

  String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
      "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
      "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
      "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};

  @RequestMapping(value = {"/hello", ""}, method = RequestMethod.GET)
  @ResponseBody
  public String hello() {
    return "Hello World!";
  }

  @GetMapping("/greeting")
  @ResponseBody
  public Greeting greeting() {
    return greeting;
  }

  @GetMapping("/greeting/{content}")
  @ResponseBody
  public String getGreetingBySimplePathWithPathVariable(@PathVariable String content) {
    return "Hello " + content.toUpperCase() + "!";
  }

  @GetMapping("/hi")
  @ResponseBody
  public Greeting hi(@RequestParam(defaultValue = "Stranger", required = false) String name) {
    return new Greeting(2, "Hello " + name + "!");
  }

  @GetMapping("hello/in/different/languages")
  public String hello(Model model,
                      @RequestParam(defaultValue = "Stranger", required = false) String name,
                      @RequestParam(defaultValue = "0,0,250", required = false) String color,
                      @RequestParam(defaultValue = "20", required = false) int fontSize) {
    model.addAttribute("hello", hellos[new Random().nextInt(hellos.length)]);
    model.addAttribute("name", name);
    model.addAttribute("color", color);
    model.addAttribute("fontSize", fontSize);
    return "hello";
  }
}
