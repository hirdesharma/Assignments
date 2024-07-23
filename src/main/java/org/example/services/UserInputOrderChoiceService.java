package org.example.services;

import java.util.Scanner;
import org.example.exceptions.InvalidArgument;

public class UserInputOrderChoiceService {
  Scanner scanner = new Scanner(System.in);

  public int userInputOrder() {
    System.out.println("1. Ascending order ");
    System.out.println("2. Descending order");
    System.out.print("Enter choice : ");
    try {
      int userInput = scanner.nextInt();
      return userInput;
    } catch (NumberFormatException e) {
      throw new InvalidArgument("order should be 1 or 2");
    }
  }
}
