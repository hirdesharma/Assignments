package org.example.services;

import java.util.Scanner;

public class UserInfoInputService {
  Scanner scanner = new Scanner(System.in);

  public void userInfoInputPrompt(AddUserDetailsService addUserDetailsService) {

    System.out.println("Enter New User Details\n");
    System.out.println("Enter Full Name");
    String fullName = scanner.nextLine();
    System.out.println("Enter Age");
    int age = Integer.parseInt(scanner.nextLine());
    System.out.println("Enter Address");
    String address = scanner.nextLine();
    System.out.println("Enter rollNo");
    String rollNo = scanner.nextLine();
    System.out.println("Enter Courses you want to enroll in, with a space between all courses");
    String[] setOfCourses = (scanner.nextLine()).split(" ");

    addUserDetailsService.setAge(age);
    addUserDetailsService.setFullName(fullName);
    addUserDetailsService.setAddress(address);
    addUserDetailsService.setSetOfCourses(setOfCourses);
    addUserDetailsService.setRollNo(rollNo);

  }
}
