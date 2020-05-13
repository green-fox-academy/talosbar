package com.greenfoxacademy.petshelter.services;

import com.greenfoxacademy.petshelter.models.Human;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface HumanService {

  List<Human> getAllHumen();

  boolean isHumanNameAddedAlready(String humanName);

  void addHuman(Human human);

  Human findHumanById(long humanId);

  void deleteHuman(long humanId);

  void editHuman(long humanId, String humanName, int humanAge);
}
