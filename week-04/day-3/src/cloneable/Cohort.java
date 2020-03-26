package cloneable;

//Create a Cohort class that has the following
//
//    fields:
//    name: the name of the cohort
//    students: a list of Students
//    mentors: a list of Mentors
//    methods:
//    addStudent(Student): adds the given Student to students list
//    addMentor(Mentor): adds the given Mentor to mentors list
//    info(): prints out "The name cohort has students.size() students and mentors.size() mentors."
//    The Cohort class has the following constructors:
//
//    Cohort(name): beside the given parameter, it sets students and mentors as empty lists

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cohort {

  private String nameOfTheCohort;
  private ArrayList<Student> students;
  private ArrayList<Mentor> mentors;

  public void addStudent(Student givenStudent) {
    students.add(givenStudent);
  }

  public void addMentor(Mentor givenMentor) {
    mentors.add(givenMentor);
  }

  public void info() {
    System.out.println("The name cohort has " + students.size() + " students and " + mentors.size() + " mentors.");
  }

  public Cohort(String nameOfTheCohort) {
    this.nameOfTheCohort = nameOfTheCohort;
    this.students = new ArrayList<>();
    this.mentors = new ArrayList<>();
  }
}
