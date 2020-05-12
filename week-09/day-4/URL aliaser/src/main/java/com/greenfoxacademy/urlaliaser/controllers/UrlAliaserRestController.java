package com.greenfoxacademy.urlaliaser.controllers;

import com.greenfoxacademy.urlaliaser.models.Link;
import com.greenfoxacademy.urlaliaser.services.UrlAliaserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlAliaserRestController {

  private UrlAliaserService urlAliaserService;

  @Autowired
  public UrlAliaserRestController(
      UrlAliaserService urlAliaserService) {
    this.urlAliaserService = urlAliaserService;
  }

  @GetMapping("/a/{alias}")
  public ResponseEntity<?> incrementHitCountIfAliasExists(Link link, @PathVariable String alias) {
    if (alias == null || !urlAliaserService.isAliasExists(link)) {
      return ResponseEntity.notFound().build();
    } else {
      link.hit();
      return ResponseEntity.ok(link.getUrl());
    }
  }

  @GetMapping("/api/links")
  public List<Link> showAllLinks() {
    return this.urlAliaserService.returnAllLinks();
  }

  @DeleteMapping("/delete/post/{id}")
  public ResponseEntity<?> deleteLink(@RequestBody Link link) {
    if (urlAliaserService.isAliasExists(link)) {
      urlAliaserService.delete(link.getId());
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else if (urlAliaserService.isAliasExists(link) &&
        !urlAliaserService.isSecretCodeMatching(link, link.getSecretCode())) {
      return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
