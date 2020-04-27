package com.greenfoxacademy.mysql;

import com.greenfoxacademy.mysql.models.Todo;
import com.greenfoxacademy.mysql.repositories.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MysqlApplication implements CommandLineRunner {

  private TodoRepository repository;

  @Autowired
  public MysqlApplication(TodoRepository repository) {
    this.repository = repository;
  }

  public static void main(String[] args) {
    SpringApplication.run(MysqlApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    repository.save(new Todo("Start the day"));
    repository.save(new Todo("Finish H2 workshop 1"));
    repository.save(new Todo("Finish JPA workshop2"));
    repository.save(new Todo("Create a CRUD project"));
  }
}
