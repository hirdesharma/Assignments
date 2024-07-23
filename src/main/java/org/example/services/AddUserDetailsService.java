package org.example.services;

import java.util.Scanner;
import org.example.exceptions.InvalidArgument;
import org.example.model.User;
import org.example.validators.UserDetailValidator;

public class AddUserDetailsService implements AddUserDetailsServiceInterface {

  String fullName;
  int age;
  String address;
  String rollNo;
  String[] setOfCourses;
  Scanner scanner;

  public void setFullName(final String fullName) {
    this.fullName = fullName;
  }

  public void setAge(final int age) {
    this.age = age;
  }

  public void setAddress(final String address) {
    this.address = address;
  }

  public void setRollNo(final String rollNo) {
    this.rollNo = rollNo;
  }

  public void setSetOfCourses(final String[] setOfCourses) {
    this.setOfCourses = setOfCourses;
  }

  @Override
  public User newUser() {
    try {
      UserInfoInputService userInfoInputService = new UserInfoInputService();
      userInfoInputService.userInfoInputPrompt(this);

      UserDetailValidator userDetailValidator = new UserDetailValidator(fullName, age, address,
          rollNo, setOfCourses);
      userDetailValidator.validate();
      return new User(fullName, rollNo, age, address, setOfCourses);
    } catch (Exception e) {
      throw new InvalidArgument("Error : " + e.getMessage());
    }
  }
}
