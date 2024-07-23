package org.example.validators;

import java.util.regex.Pattern;
import org.example.enums.CourseType;
import org.example.exceptions.InvalidArgument;

public class UserDetailValidator {
  String fullName;
  int age;
  String address;
  String rollNo;
  String[] setOfCourses;

  public UserDetailValidator(String fullName, int age, String address, String rollNo,
                             String[] setOfCourses) {
    this.fullName = fullName;
    this.age = age;
    this.address = address;
    this.rollNo = rollNo;
    this.setOfCourses = setOfCourses;
  }

  public void validate() {
    validateFullName();
    validateAge();
    validateAddress();
    validateRollNo();
    validateSetOfCourses();
  }

  private void validateFullName() {
    if (fullName == null || fullName.trim().isEmpty()) {
      throw new InvalidArgument("Full name must not be empty.");
    }
    if (!Pattern.matches("^[a-z]+( [a-z]+)?$", fullName.toLowerCase())) {
      throw new InvalidArgument("Full Name must be a valid name in the format : FirstName "
          + "LastName");
    }
  }

  private void validateAge() {
    if (age < 1 || age > 120) {
      throw new InvalidArgument("Age must be between 1 and 120.");
    }
  }

  private void validateAddress() {
    if (address == null || address.trim().isEmpty()) {
      throw new InvalidArgument("Address must not be empty or null.");
    }
  }

  private void validateRollNo() {
    if (rollNo == null || rollNo.trim().isEmpty()) {
      throw new InvalidArgument("Roll number must not be empty or null");
    }
  }

  private void validateSetOfCourses() {
    if (setOfCourses == null || setOfCourses.length < 4) {
      throw new InvalidArgument("Set of courses must be at least 4 and  not be empty.");
    }
    for (String course : setOfCourses) {
      try {
        CourseType.fromString(course);
      } catch (InvalidArgument e) {
        throw new InvalidArgument("Invalid course: " + course);
      }
    }
  }
}
