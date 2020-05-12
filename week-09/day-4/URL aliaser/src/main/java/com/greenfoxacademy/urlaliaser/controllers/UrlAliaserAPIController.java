package com.greenfoxacademy.urlaliaser.controllers;

import com.greenfoxacademy.urlaliaser.dtos.SecretDTO;
import com.greenfoxacademy.urlaliaser.models.Link;
import com.greenfoxacademy.urlaliaser.services.UrlAliaserService;
import java.util.List;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlAliaserAPIController {

  private UrlAliaserService urlAliaserService;

  @Autowired
  public UrlAliaserAPIController(
      UrlAliaserService urlAliaserService) {
    this.urlAliaserService = urlAliaserService;
  }

  @GetMapping("/api/links")
  public List<Link> showAllLinks() {
    return urlAliaserService.returnAllLinks();
  }

  @DeleteMapping("/delete/post/{id}")
  public ResponseEntity<?> deleteLink(@PathVariable long id, @RequestBody SecretDTO secretCode) {
    HttpStatus status;

    try {
      urlAliaserService.deleteLinkBySecretCode(secretCode.getSecretCode(), id);
      status = HttpStatus.NO_CONTENT;
    } catch (IllegalArgumentException ex) {
      status = HttpStatus.FORBIDDEN;
    } catch (NotFoundException ex) {
      status = HttpStatus.NOT_FOUND;
    }
    return ResponseEntity.status(status).build();
  }
}
