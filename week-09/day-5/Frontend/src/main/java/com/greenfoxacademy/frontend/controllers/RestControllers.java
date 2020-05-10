package com.greenfoxacademy.frontend.controllers;

import com.greenfoxacademy.frontend.models.AppendA;
import com.greenfoxacademy.frontend.models.DoUntil;
import com.greenfoxacademy.frontend.models.Doubling;
import com.greenfoxacademy.frontend.models.Error;
import com.greenfoxacademy.frontend.models.WelcomeMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllers {

  @GetMapping("/doubling")
  public ResponseEntity<?> doubling(@RequestParam(required = false) Integer input) {
    if (input != null) {
      return ResponseEntity.ok(new Doubling(input));
    } else {
      return ResponseEntity
          .status(HttpStatus.BAD_REQUEST)
          .body(new Error("Please provide an input!"));
    }
  }

  @GetMapping("/greeter")
  public ResponseEntity<?> getWelcomeMessage(@RequestParam(required = false) String name,
                                             @RequestParam(required = false) String title) {
    if (name == null && title == null) {
      return ResponseEntity
          .badRequest()
          .body(new Error("Please provide a name and a title!"));
    } else if (name == null) {
      return ResponseEntity
          .status(HttpStatus.BAD_REQUEST)
          .body(new Error("Please provide a name!"));
    } else if (title == null) {
      return ResponseEntity
          .status(HttpStatus.BAD_REQUEST)
          .body(new Error("Please provide a title!"));
    } else {
      return ResponseEntity.ok(new WelcomeMessage(name, title));
    }
  }

  @GetMapping("/appenda/{appendable}")
  public ResponseEntity<?> append(@PathVariable String appendable) {
    if (appendable == null) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(new AppendA(appendable));
    }
  }

  @PostMapping("/dountil/{action}")
  public ResponseEntity<?> doUntil(@PathVariable String action, @RequestBody DoUntil doUntil) {
    if (doUntil.getUntil() == null) {
      return ResponseEntity.badRequest().body(new Error("Please provide a number!"));
    }
    doUntil.setResultByAction(action);
    return ResponseEntity.ok(doUntil);
  }
}
