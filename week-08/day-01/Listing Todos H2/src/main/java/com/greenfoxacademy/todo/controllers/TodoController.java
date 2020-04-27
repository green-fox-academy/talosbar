package com.greenfoxacademy.todo.controllers;

import com.greenfoxacademy.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {

  private TodoRepository repository;

  @Autowired
  public TodoController(TodoRepository repository) {
    this.repository = repository;
  }

  @GetMapping(value = {"/", "/list"})
  public String list(Model model) {
    model.addAttribute("todos", repository.findAll());
    return "todolist";
  }
}
