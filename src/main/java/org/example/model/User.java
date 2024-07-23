package org.example.model;

import java.io.Serializable;
import java.util.Arrays;

public class User implements Comparable<User>, Serializable {
  private String name;
  private int age;
  private String address;
  private String rollNumber;
  private String[] enrolledCourses;

  public User(String name, String rollNumber, int age, String address,
              String[] enrolledCourses) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.rollNumber = rollNumber;
    this.enrolledCourses = enrolledCourses;
  }

  public void display() {
    System.out.println(
        "User { name = '" + name + "', rollNumber = '" + rollNumber + "', age = " + age + ", "
            + "address = '" + address + "' enrolled courses = " + Arrays.toString(enrolledCourses)
            + " }");
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getAddress() {
    return address;
  }

  public String getRollNumber() {
    return rollNumber;
  }

  public String[] getEnrolledCourses() {
    return enrolledCourses;
  }

  public int compareTo(User o) {
    if (name.equals(o.name))
      return rollNumber.compareTo(o.rollNumber);
    return name.compareTo(o.name);
  }
}
