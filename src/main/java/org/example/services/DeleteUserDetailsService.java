package org.example.services;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import org.example.exceptions.InvalidArgument;
import org.example.model.User;

public class DeleteUserDetailsService implements DeleteUserDetailsServiceInterface {

  @Override
  public void deleteUser(Set<User> users) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter RollNo Which you want to delete");
    String rollNo = scanner.nextLine();

    deleteUserByRollNo(users, rollNo);
  }

  private void deleteUserByRollNo(Set<User> users, String rollNo) {
    Iterator<User> iterator = users.iterator();
    while (iterator.hasNext()) {
      User user = iterator.next();
      if (user.getRollNumber().equals(rollNo)) {
        iterator.remove();
        return;
      }
    }
    throw new InvalidArgument("User with rollNo : " + rollNo + " Not Found");
  }
}
