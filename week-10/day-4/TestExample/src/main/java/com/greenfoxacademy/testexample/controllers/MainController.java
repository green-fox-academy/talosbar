package com.greenfoxacademy.testexample.controllers;

import com.greenfoxacademy.testexample.models.ErrorItem;
import com.greenfoxacademy.testexample.models.Translated;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  @RequestMapping(path = "/groot", method = RequestMethod.GET)
  public ResponseEntity<?> getMessage(@RequestParam(required = false) String message) {
    if (message != null) {
      return ResponseEntity.status(HttpStatus.OK).body(new Translated(message));
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorItem());
    }
  }

}
